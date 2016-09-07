package com.zhangdxchn.service.impl;

import com.zhangdxchn.lib.weixin.WeiXinEnum;
import com.zhangdxchn.lib.weixin.bean.*;
import com.zhangdxchn.lib.weixin.bean.req.TextMessage;
import com.zhangdxchn.lib.weixin.comm.MessageUtil;
import com.zhangdxchn.service.IWxService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * Created by zhangdx on 16/8/30.
 */
@Service
public class WxService implements IWxService {
    private static final Logger logger = Logger.getLogger(WxService.class);


    @Override
    public WeixinOauth2Token getOauth2AccessToken(String code) {
        return null;
    }

    @Override
    public WeixinOauth2Token refreshOauth2AccessToken(String refreshToken) {
        return null;
    }

    @Override
    public SNSUserInfo getSNSUserInfo(String accessToken, String openId) {
        return null;
    }

    @Override
    public WeixinQRCode createTemporaryQRCode(String accessToken, int expireSeconds, int sceneId) {
        return null;
    }

    @Override
    public String createPermanentQRCode(String accessToken, String sceneString) {
        return null;
    }

    @Override
    public String saveQRCode(String ticket, String savePath) {
        return null;
    }

    @Override
    public String getQRCodeURL(String ticket) {
        return null;
    }

    @Override
    public String saveQRCode(String sceneString) {
        return null;
    }

    @Override
    public WeixinUserInfo getUserInfo(String accessToken, String openId) {
        return null;
    }

    @Override
    public String processRequest(HttpServletRequest request) {
        String respXml = null;
        try {
            Map<String, String> requestMap = MessageUtil.parseXml(request);
            String userOpenId = requestMap.get("FromUserName");
            String selfOpenId = requestMap.get("ToUserName");
            String msgType = requestMap.get("MsgType");
            TextMessage textMessage = initTextMessage(userOpenId, selfOpenId);
            switch (WeiXinEnum.REQ_MESSAGE_TYPE.getMessgeType(msgType)) {
                case EVENT:
                    String eventType = requestMap.get("Event");
                    String eventKey = requestMap.get("EventKey");
                    switch (WeiXinEnum.REQ_EVENT_TYPE.getEventType(eventType)) {
                        case SUBSCRIBE:
                        case SCAN:
                            //todo
//                            respXml = scanAndSubscribeService.processScanOrSubscribe(userOpenId, selfOpenId, textMessage, eventKey);
                            break;
                        case CLICK:
                            logger.debug("eventKey:" + eventKey);
                            //todo
//                            respXml = wxMenuService.getTextReplyByMenuKey(eventKey,textMessage);
                            break;
                        default:
                    }
                    break;
                case TEXT:
                    //todo
//                    wxMessageService.addMsg(userOpenId, msgType, requestMap);
//                    respXml = MessageUtil.messageToXml(wxMessageService.getKeyRuleReplyMsg(userOpenId, selfOpenId, requestMap.get("Content")));
                    break;
                case IMAGE:
                    //todo
//                    wxMessageService.addMsg(userOpenId, msgType, requestMap);
//                    respXml = MessageUtil.messageToXml(wxMessageService.getAutoReplyMsg(userOpenId, selfOpenId));
                    break;
                default:
                    //todo
//                    textMessage.setContent("请通过菜单使用导航服务");
//                    respXml = MessageUtil.messageToXml(textMessage);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respXml;
    }

    @Override
    public Token getToken() {
        return null;
    }

    private TextMessage initTextMessage(String fromUserName, String toUserName) {
        TextMessage textMessage = new TextMessage();
        textMessage.setToUserName(fromUserName);
        textMessage.setFromUserName(toUserName);
        textMessage.setCreateTime(new Date().getTime());
        textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
        return textMessage;
    }
}
