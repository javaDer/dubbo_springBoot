package com.wwjswly.dubbo.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wwjswly.dubbo.api.service.WxService;
import okhttp3.*;

import java.io.IOException;

/**
 * Created by Javaer on 2018-08-30.
 */
@Service(version = "${demo.service.version}",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class WxServiceImpl implements WxService {
    private final static String getAccessTockenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx3f5f5a1641ce005a&secret=4281594d554fb1bcab1123a714f701f5";


    @Override
    public String getAccessToken() {
        String JsonAccessToken = "";
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(getAccessTockenUrl).build();

            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new IOException("服务器端错误: " + response);
            }
            Headers responseHeaders = response.headers();
            for (int i = 0; i < responseHeaders.size(); i++) {
                System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
            }
//            System.out.println(response.body().string());
//            .string()只可以条用一次
            JsonAccessToken = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return JsonAccessToken;
    }
}
