package com.ecoop.annotation;

import java.lang.annotation.*;

/**
 * @ClassName Authenticate
 * @Description TODO
 * @Author crazy
 * @Date 2019-07-02 10:18
 * @Version 1.0
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Authenticate {

    /**
     * 权限列表，以“,”分割的权限编号
     *
     * @return
     */
    String permissions();

}
