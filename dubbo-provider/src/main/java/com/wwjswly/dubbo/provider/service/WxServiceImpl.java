package com.wwjswly.dubbo.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.riversoft.weixin.common.jsapi.JsAPISignature;
import com.riversoft.weixin.mp.card.Cards;
import com.riversoft.weixin.mp.card.bean.BaseInfo;
import com.riversoft.weixin.mp.card.bean.Discount;
import com.riversoft.weixin.mp.card.bean.Member;
import com.riversoft.weixin.mp.jsapi.JsAPIs;
import com.wwjswly.dubbo.api.service.WxService;
import com.wwjswly.dubbo.provider.utils.RedisUtils;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Javaer on 2018-08-30.
 */
@Service(version = "${demo.service.version}",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class WxServiceImpl implements WxService {
    @Autowired
    private RedisUtils redisUtils;
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
            JsonAccessToken = response.body().string();
            JSONObject json_str = JSON.parseObject(JsonAccessToken);
            String accessToken = json_str.getString("access_token");
            Long expireTime = json_str.getLong("expires_in");
            this.redisUtils.set("access_token", accessToken, expireTime);


        } catch (IOException e) {
            e.printStackTrace();
        }
        return JsonAccessToken;
    }

    @Override
    public String createCard() {
        Discount discount = new Discount();
        discount.setDiscount(90);

        BaseInfo baseInfo = new BaseInfo();
        baseInfo.setLogoUrl("https://jswly.oss-cn-beijing.aliyuncs.com/test/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20180831113203.png");
        baseInfo.setCodeType("CODE_TYPE_BARCODE");
        baseInfo.setBrandName("汽车服务综合市场");
        baseInfo.setTitle("999元车辆保修卡");
        baseInfo.setColor("Color010");
        baseInfo.setNotice("请到指定门店出示使用");
        baseInfo.setDescription("该优惠券一次性使用不退额,不可叠加使用");
        baseInfo.setSku(new BaseInfo.Sku(10));
        BaseInfo.DateInfo dateInfo = new BaseInfo.DateInfo();
        dateInfo.setType(BaseInfo.DateInfo.DateInfoType.DATE_TYPE_FIX_TERM);
        dateInfo.setFixedTerm(30);
        dateInfo.setFixedTermBegin(0);
        baseInfo.setDateInfo(dateInfo);
        baseInfo.setServicePhone("0935-6356399");
        baseInfo.setCanGiveFriend(false);

        discount.setBaseInfo(baseInfo);
        String result = Cards.defaultCards().discount(discount).toString();
        System.out.println(result);
        return result;
    }

    @Override
    public Map<String, Object> getWxJsAPISignature() {
        Map<String, Object> map = new HashMap<String, Object>();
        String Url = "http://wx.wwtianmei.cn/wx";
        JsAPISignature jsAPISignature = JsAPIs.defaultJsAPIs().createJsAPISignature(Url);

        map.put("appId", jsAPISignature.getAppId());
        map.put("timestamp", jsAPISignature.getTimestamp() + "");
        map.put("nonce", jsAPISignature.getNonce());
        map.put("signature", jsAPISignature.getSignature());
        map.put("url", jsAPISignature.getUrl());
        return map;
    }

}
