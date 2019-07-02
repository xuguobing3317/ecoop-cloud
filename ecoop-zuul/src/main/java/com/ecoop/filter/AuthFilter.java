package com.ecoop.filter;

import com.alibaba.fastjson.JSON;
import com.ecoop.commons.R;
import com.ecoop.commons.RespCodeEnum;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName AuthFilter
 * @Description TODO
 * @Author crazy
 * @Date 2019-07-01 21:12
 * @Version 1.0
 **/
@Component
public class AuthFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 过滤器的类型，它决定过滤器在请求的哪个生命周期中执行。
     * 这里定义为pre，代表会在请求被路由之前执行。
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * filter执行顺序，通过数字指定。
     * 数字越大，优先级越低。
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 2;
    }


    /**
     * 判断该过滤器是否需要被执行。这里我们直接返回了true，因此该过滤器对所有请求都会生效。
     * 实际运用中我们可以利用该函数来指定过滤器的有效范围。
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }


    /**
     * 过滤器的具体逻辑
     *
     * @return
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.getResponse().setContentType("text/html;charset=UTF-8");

        HttpServletRequest request = ctx.getRequest();

        // 根据URL来进行判断
        String urlPath = request.getRequestURI();
        logger.info(urlPath);

        if (urlPath.indexOf("member") >= 0) {
            //判断是否具有权限
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(200);
            ctx.setResponseBody(JSON.toJSONString(R.doRet(RespCodeEnum.AUTH_ERROR)));
        } else if (urlPath.indexOf("manage") >= 0) {
            //判断是否具有权限
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(200);
            ctx.setResponseBody(JSON.toJSONString(R.doRet(RespCodeEnum.AUTH_ERROR)));
        } else {

        }


        return null;
    }
}
