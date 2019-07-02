package com.ecoop.commons;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * @ClassName R
 * @Description TODO
 * @Author crazy
 * @Date 2019-07-01 20:56
 * @Version 1.0
 **/

@Data
public class R {

    private String code;

    private String msg;

    private Object data;

    public R() {

    }


    public R (String code , String msg) {
        this.code = code;
        this.msg = msg;
    }



    public R (RespCodeEnum respCodeEnum) {
        this.code = respCodeEnum.getCode();
        this.msg = respCodeEnum.getMsg();
    }


    public static R doSuccess() {
        return new R(RespCodeEnum.SUCCESS);
    }

    public static R doRet(String code, String msg){
        return new R(code, msg);
    }

    public static R doRet(RespCodeEnum respCodeEnum) {
        return new R(respCodeEnum);
    }

}
