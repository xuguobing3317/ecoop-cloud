package com.ecoop.ecoopgateway.filter;

import com.ecoop.ecoopgateway.config.ServerProperties;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.netty.buffer.ByteBufAllocator;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.core.io.buffer.NettyDataBufferFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @ClassName TokenFilter
 * @Description TODO
 * @Author crazy
 * @Date 2019-08-07 17:42
 * @Version 1.0
 **/
public class TokenFilter implements GlobalFilter, Ordered {

    private ServerProperties serverProperties;

    public TokenFilter(ServerProperties serverProperties) {
        this.serverProperties = serverProperties;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        boolean tokenFlag = false;

        URI uri = exchange.getRequest().getURI();

        String path = uri.getPath();

        for (String url : serverProperties.getAuthUrl()) {
            tokenFlag = path.startsWith(url);
            if (tokenFlag) {
                break;
            }
        }

        if (!tokenFlag) {
            return chain.filter(exchange.mutate().request(exchange.getRequest()).build());
        }

        HttpMethod method = exchange.getRequest().getMethod();

        //现在工作台的处理是有问题的。
        //token应该是放在header里面，不要处理requestparams
        if (method == HttpMethod.GET) {
            return getFilter(exchange,chain);
        } else if (method == HttpMethod.POST) {
            return postFilter(exchange,chain);
        } else {
            return chain.filter(exchange.mutate().request(exchange.getRequest()).build());
        }


    }
    Mono<Void> postFilter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //从请求里获取Post请求体
        String bodyStr = resolveBodyFromRequest(exchange.getRequest());
        //TODO 得到Post请求的请求参数后，做你想做的事


        //下面的将请求体再次封装写回到request里，传到下一级，否则，由于请求体已被消费，后续的服务将取不到值
        URI uri = exchange.getRequest().getURI();
        ServerHttpRequest request = exchange.getRequest().mutate().uri(uri).build();
        DataBuffer bodyDataBuffer = stringBuffer(bodyStr);
        Flux<DataBuffer> bodyFlux = Flux.just(bodyDataBuffer);

        request = new ServerHttpRequestDecorator(request) {
            @Override
            public Flux<DataBuffer> getBody() {
                return bodyFlux;
            }
        };
        //封装request，传给下一级
        return chain.filter(exchange.mutate().request(request).build());
    }


    private String resolveBodyFromRequest(ServerHttpRequest serverHttpRequest) {
        //获取请求体
        Flux<DataBuffer> body = serverHttpRequest.getBody();

        AtomicReference<String> bodyRef = new AtomicReference<>();
        body.subscribe(buffer -> {
            CharBuffer charBuffer = StandardCharsets.UTF_8.decode(buffer.asByteBuffer());
            DataBufferUtils.release(buffer);
            bodyRef.set(charBuffer.toString());
        });
        //获取request body
        return bodyRef.get();
    }

    private DataBuffer stringBuffer(String value) {
        byte[] bytes = value.getBytes(StandardCharsets.UTF_8);

        NettyDataBufferFactory nettyDataBufferFactory = new NettyDataBufferFactory(ByteBufAllocator.DEFAULT);
        DataBuffer buffer = nettyDataBufferFactory.allocateBuffer(bytes.length);
        buffer.write(bytes);
        return buffer;
    }


    Mono<Void> getFilter(ServerWebExchange exchange, GatewayFilterChain chain) {
        List<String> paramList = exchange.getRequest().getQueryParams().get("token");
        if (null == paramList || paramList.isEmpty()) {
            return returnFail(exchange.getResponse());
        }
        HttpResponse<JsonNode> asJson = null;
        try {
            asJson = Unirest.get(serverProperties.getZsuserUrl() + "homeController/judgeToken").queryString("token", paramList.get(0))
                    .asJson();
        } catch (UnirestException e) {
            return returnFail(exchange.getResponse());
        }
        if (asJson == null || asJson.getBody() == null || asJson.getStatus() != 200) {
            return returnFail(exchange.getResponse());
        } else {
            JSONObject parseObject = JSONObject.parseObject(asJson.getBody().toString());
            if ("0".equals(parseObject.getString("code"))) {
                return returnFail(exchange.getResponse());
            } else {

                URI uri = exchange.getRequest().getURI();
                StringBuilder query = new StringBuilder();
                String originalQuery = uri.getRawQuery();

                if (StringUtils.hasText(originalQuery)) {
                    query.append(originalQuery);
                    if (originalQuery.charAt(originalQuery.length() - 1) != '&') {
                        query.append('&');
                    }
                }

                JSONObject userDTO = parseObject.getJSONObject("user");

                String puid = userDTO.getString("p_uid");
                if (!StringUtils.isEmpty(puid)) {
                    query.append("uid="+puid);
                }

                JSONObject user = userDTO.getJSONObject("user");
                String userId = user.getString("user_id");
                query.append("&userId="+userId);


                URI newUri = UriComponentsBuilder.fromUri(uri)
                        .replaceQuery(query.toString())
                        .build(true)
                        .toUri();

                exchange.getRequest().mutate().uri(newUri).build();

                return chain.filter(exchange.mutate().request(exchange.getRequest()).build());
            }
        }
    }




    @Override
    public int getOrder() {
        return -201;
    }


    private Mono<Void> returnFail(ServerHttpResponse response) {
        JSONObject tnStatus = new JSONObject();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 9);
        JSONObject tnError = new JSONObject();
        tnError.put("message", "token错误!");
        JSONArray tnErrors = new JSONArray();
        tnErrors.add(tnError);
        jsonObject.put("tnErrors", tnErrors);
        tnStatus.put("tnStatus", jsonObject);

        DataBuffer buffer = response.bufferFactory().wrap(JSON.toJSONString(tnStatus).getBytes(StandardCharsets.UTF_8));
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        return response.writeWith(Mono.just(buffer));
    }


}
