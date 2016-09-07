package com.zhangdxchn.service;


import com.zhangdxchn.lib.weixin.bean.resp.BaseMessage;

import java.util.Map;

public interface IWxMessageService {
    /**
     * 入库
     *
     * @param fromUserName
     * @param msgType
     * @param requestMap
     * @return
     */
    Integer addMsg(String fromUserName, String msgType, Map<String, String> requestMap);

    /**
     * 获取自动回复消息
     *
     * @return
     */
    BaseMessage getAutoReplyMsg(String userOpenId, String selfOpenId);

    /**
     * 获取自动回复消息
     *
     * @return
     */
    BaseMessage getSubscribeReplyMsg(String userOpenId, String selfOpenId);

    /**
     * 获取关键字回复消息
     *
     * @param userOpenId
     * @param selfOpenId
     * @param content
     * @return
     */
    BaseMessage getKeyRuleReplyMsg(String userOpenId, String selfOpenId, String content);
}