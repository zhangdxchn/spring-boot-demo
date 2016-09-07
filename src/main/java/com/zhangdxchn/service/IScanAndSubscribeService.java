package com.zhangdxchn.service;


import com.zhangdxchn.lib.weixin.bean.resp.TextMessage;

public interface IScanAndSubscribeService {
	/**
	 * 处理关注和扫描业务
	 * @param userOpenId
	 * @param selfOpenId
	 * @param textMessage
	 * @param eventKey
     * @return
     */
	String processScanOrSubscribe(String userOpenId, String selfOpenId, TextMessage textMessage, String eventKey);

}