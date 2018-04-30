package com.louisgeek.myarch.json;

public class BaseJson<T> {
    private int code;
    private String msg;
    private T data;
    private JsonDataType jsonDataType;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public JsonDataType getJsonDataType() {
        return jsonDataType;
    }

    public void setJsonDataType(JsonDataType jsonDataType) {
        this.jsonDataType = jsonDataType;
    }
}
