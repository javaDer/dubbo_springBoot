package com.wwjswly.dubbo.provider.wx;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Administrator
 */
public class WxCardSignTest {
    public static void main(String[] args) throws Exception {
        WxCardSign signer = new WxCardSign();
        signer.AddData("test1");
        signer.AddData(12312312);
        signer.AddData(55312312);
        signer.AddData("test");
        signer.AddData("test2");
        System.out.println(signer.GetSignature());
    }

}