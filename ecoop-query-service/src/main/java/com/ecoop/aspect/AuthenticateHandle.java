package com.ecoop.aspect;

import com.ecoop.annotation.Authenticate;
import com.ecoop.commons.R;
import com.ecoop.commons.RespCodeEnum;
import com.google.common.collect.Lists;
import org.apache.catalina.security.SecurityUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName AuthenticateHandle
 * @Description TODO
 * @Author crazy
 * @Date 2019-07-02 10:19
 * @Version 1.0
 **/
@Aspect
@Component
public class AuthenticateHandle {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticateHandle.class);

    @Around("execution(public * * (..) ) && @annotation(com.ecoop.annotation.Authenticate)")
    public R access(ProceedingJoinPoint point) {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String userId = request.getHeader("user_id");


        //1、判断Redis中是否存在用户权限信息
        //2、如果存在， 从redis中获取之后，进行角色比对
        //3、如果不存在，从数据库中获取信息后保存到redis中，然后进行第二步

        List<String> info = getAuthFromRedis();


        MethodSignature methodSignature = MethodSignature.class.cast(point.getSignature());
        Authenticate auth = fetchAuth(methodSignature);
        if (!handleAuth(auth, info)) {
            logger.error("您没有权限进行该操作，方法名：{}，用户ID：{}", methodSignature, userId);
            return R.doRet(RespCodeEnum.AUTH_ERROR);
        }

        try {
            return (R) point.proceed();
        } catch (Throwable e) {
            logger.error("", e);
            return R.doRet(RespCodeEnum.SERVER_ERROR);
        }
    }

    private Authenticate fetchAuth(MethodSignature methodSignature) {
        return methodSignature.getMethod().getAnnotation(Authenticate.class);
    }

    private Boolean handleAuth(Authenticate auth, List<String> infos) {
        String[] permissionsStr = auth.permissions().split(",");
        List<String> permissions = Lists.newArrayList(permissionsStr);
        for (String permission : infos) {
            if (permissions.contains(permission)) {
                return true;
            }
        }
        //默认返回true， 实际业务逻辑中， 需要进行判断
        if (permissions.contains("auth")) {
            return false;
        }
        return true;
    }

    private List<String> getAuthFromRedis() {
        return new ArrayList<>();
    }
}
