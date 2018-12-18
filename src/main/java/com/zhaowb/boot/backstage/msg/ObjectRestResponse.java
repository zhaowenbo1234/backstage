package com.zhaowb.boot.backstage.msg;

/**
 * @Description
 * @auther zwb
 * @create 2018-12-18 20:16
 */
public class ObjectRestResponse<T> {
    /**
     * 错误代码
     */
    private Integer code;
    /**
     * 返回数据
     */
    private T data;
    /**
     * 错误信息
     */
    private String msg;

    public ObjectRestResponse() {
    }

    public ObjectRestResponse(Integer code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public ObjectRestResponse code(Integer code) {
        this.setCode(code);
        return this;
    }

    public ObjectRestResponse data(T data) {
        this.setData(data);
        return this;
    }

    public ObjectRestResponse msg(String msg) {
        this.setMsg(msg);
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ObjectRestResponse{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
