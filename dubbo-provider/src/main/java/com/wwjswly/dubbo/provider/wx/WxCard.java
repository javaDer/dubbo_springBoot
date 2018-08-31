package com.wwjswly.dubbo.provider.wx;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jackylian
 */
public abstract class WxCard
{

    protected WxCardBaseInfo m_baseInfo;
    protected org.json.JSONObject m_requestData;
    protected org.json.JSONObject m_data;
    protected String m_cardType;

    public WxCard()
    {
        m_baseInfo = new WxCardBaseInfo();
        m_requestData = new org.json.JSONObject();
    }
    
    void init(String cardType)
    {
        m_cardType = cardType;
        org.json.JSONObject obj = new org.json.JSONObject();
        obj.put("card_type", m_cardType.toUpperCase());
        m_data = new org.json.JSONObject();
        m_data.put("base_info", m_baseInfo.m_data);
        obj.put(m_cardType.toLowerCase(), m_data);
        m_requestData.put("card", obj);
    }
    
    public org.json.JSONObject getJSONObject()
    {
        return m_requestData;
    }

    public String toJsonString()
    {
        return m_requestData.toString();
    }
    
    @Override
    public String toString()
    {
        return toJsonString();
    }

    public WxCardBaseInfo getBaseInfo()
    {
        return m_baseInfo;
    }

}
