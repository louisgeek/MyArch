package com.louisgeek.myarch;

public class ThrowableHelper {
    //对应HTTP的状态码
    public static final int UNAUTHORIZED = 401;
    public static final int FORBIDDEN = 403;
    public static final int NOT_FOUND = 404;
    public static final int REQUEST_TIMEOUT = 408;
    public static final int INTERNAL_SERVER_ERROR = 500;
    public static final int BAD_GATEWAY = 502;
    public static final int SERVICE_UNAVAILABLE = 503;
    public static final int GATEWAY_TIMEOUT = 504;

/*
    200	OK	请求成功
201	CREATED	创建成功
202	ACCEPTED	更新成功
400	BAD REQUEST	请求的地址不存在或者包含不支持的参数
401	UNAUTHORIZED	未授权
403	FORBIDDEN	被禁止访问
404	NOT FOUND	请求的资源不存在
500	INTERNAL SERVER ERROR	内部错误*/



    public static final int CALL_CANCEL = -50;
    public static final int CALL_ERROR = -100;




/*    SocketTimeoutException 网络超时 1000
    ConnectException 链接异常 1001
    UnknownHostException Host异常 1001
    MalformedJsonException 解析异常 1020*/

    /*网络错误*/
    public static final int NETWORD_ERROR = 0x1;
    /*http_错误*/
    public static final int HTTP_ERROR = 0x2;
    /*fastjson错误*/
    public static final int JSON_ERROR = 0x3;
    /*未知错误*/
    public static final int UNKNOWN_ERROR = 0x4;
    /*运行时异常-包含自定义异常*/
    public static final int RUNTIME_ERROR = 0x5;
    /*无法解析该域名*/
    public static final int UNKOWNHOST_ERROR = 0x6;

}
