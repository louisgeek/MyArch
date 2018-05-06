package com.louisgeek.myarch.http;


import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class HttpConstant{
    public static final int CONNECT_TIME_OUT = 30_000;
    public static final int READ_TIME_OUT = 30_000;
    public static final int WRITE_TIME_OUT = 30_000;

    public static final int CALL_CANCEL = -50;
    public static final int CALL_ERROR = -100;
}
