package com.zhangdxchn.service;


import com.zhangdxchn.lib.weixin.bean.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhangdx on 16/8/30.
 */
public interface IWxService {
    /**
     * 获取网页授权凭证
     */
    WeixinOauth2Token getOauth2AccessToken(String code);

    /**
     * 刷新网页授权凭证
     */
    WeixinOauth2Token refreshOauth2AccessToken(String refreshToken);

    /**
     * 通过网页授权获取用户信息
     */
    @SuppressWarnings({"deprecation", "unchecked"})
    SNSUserInfo getSNSUserInfo(String accessToken, String openId);

    /**
     * 创建临时带参二维码
     */
    WeixinQRCode createTemporaryQRCode(String accessToken, int expireSeconds, int sceneId);

    /**
     * 创建永久带参二维码
     */
    String createPermanentQRCode(String accessToken, String sceneString);

    /**
     * 换取二维码
     */
    String saveQRCode(String ticket, String savePath);

    String getQRCodeURL(String ticket);

    String saveQRCode(String sceneString);

    /**
     * 获取用户信息
     */
    WeixinUserInfo getUserInfo(String accessToken, String openId);

    /**
     * 处理微信发来的请求
     */
    String processRequest(HttpServletRequest request);

    /**
     * 获取token
     *
     * @return
     */
    Token getToken();
}
