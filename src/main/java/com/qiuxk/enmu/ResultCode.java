package com.qiuxk.enmu;

/**
 *
 * @author qiuxk
 * @Description: 返回值枚举类
 * @create 2019/9/27
 **/

public enum ResultCode {
    SUCCESS("0000","成功"),
    FAIIL("0001","失败");

    private String code;
    private String value;

    ResultCode() {
    }

    ResultCode(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public  String code(){
        return  this.code;
    }
    public  String value(){
        return  this.value;
    }



}
