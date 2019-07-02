package com.ecoop.commons;


import com.alibaba.fastjson.JSON;

/**
 * @ClassName RespCodeEnum
 * @Description TODO
 * @Author crazy
 * @Date 2019-07-01 20:57
 * @Version 1.0
 **/
public enum RespCodeEnum {

    SUCCESS("000000", "成功"),
    AUTH_ERROR("100001", "无权限"),
    TOKEN_ERROR("100002", "token为空"),
    SERVER_ERROR("999999", "服务异常");


    private String code;

    private String msg;

    RespCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
