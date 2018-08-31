package com.wwjswly.dubbo.api.service;

import java.util.Map;

/**
 * Created by Javaer on 2018/8/31.
 */
public interface WxService {
    String getAccessToken();

    String createCard();

    Map<String, Object> getWxJsAPISignature();
}
