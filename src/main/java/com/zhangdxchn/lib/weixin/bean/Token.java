package com.zhangdxchn.lib.weixin.bean;

/**
 * 凭证
 */
public class Token {
//    //线上
//    public static final String APPID = "wxec2698856db6a0f6";
//    public static final String SECRET = "9ccc25b7468a87f3ab317ae46c016a1d";
    //测试
    public static final String APPID = "wx8517971af979361b";
    public static final String SECRET = "d4624c36b6795d1d99dcf0547af5443d";


    private String accessToken;

    private int expiresIn;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public Token() {
    }

    public Token(String accessToken) {
        super();
        this.accessToken = accessToken;
    }
}