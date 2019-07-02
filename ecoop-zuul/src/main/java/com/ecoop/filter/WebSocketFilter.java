package com.ecoop.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName WebSocketFilter
 * @Description TODO
 * @Author crazy
 * @Date 2019-07-02 14:02
 * @Version 1.0
 **/
@Component
public class WebSocketFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }
    @Override
    public int filterOrder() {
        return 0;
    }
    @Override
    public boolean shouldFilter() {
        return true;
    }
    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
//        String upgradeHeader = request.getHeader("Upgrade");
//        if (null == upgradeHeader) {
//            upgradeHeader = request.getHeader("upgrade");
//        }
//        if (null != upgradeHeader && "websocket".equalsIgnoreCase(upgradeHeader)) {
            context.addZuulRequestHeader("connection", "Upgrade");
//        }
        return null;
    }
}
