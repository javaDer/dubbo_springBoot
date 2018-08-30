package com.wwjswly.dubbo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wwjswly.dubbo.api.service.WxService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Javaer on 2018-08-30.
 */
@RestController
public class WxController {
    @Reference(version = "${demo.service.version}",
            application = "${dubbo.application.id}",
            url = "dubbo://127.0.0.1:20880")
    private WxService wxService;

    @RequestMapping("/get_access_token")
    @ResponseBody
    public String getAccessToken() {
        String str = wxService.getAccessToken();
        System.out.println(str);
        return str;
    }
}
