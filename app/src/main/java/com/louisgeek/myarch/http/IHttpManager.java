package com.louisgeek.myarch.http;

import java.util.Map;

public interface IHttpManager {
    String get(String url, Map<String, String> headersMap);

    String post(String url, Map<String, String> headersMap, Map<String, String> paramsMap);
}
