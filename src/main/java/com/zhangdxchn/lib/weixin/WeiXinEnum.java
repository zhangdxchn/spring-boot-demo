package com.zhangdxchn.lib.weixin;

/**
 * Created by Administrator on 2016/5/18.
 */
public interface WeiXinEnum {
    /**
     * 审核结果:0.未审核;  1.审核通过;  2.审核不通过
     */
    enum CustomerState {
        NEW_CUSTOMER,
        CUSTOMER_NOPHONE_NOTFOLLOWUP_NOBUY,
        HAVE_BUY_SERVICE,
        CUSTOMER_WITHPHONE_NOTFOLLOWUP_NOBUY,
        FOLLOWUP_CUSTOMER,
        FOLLOWUP_CUSTOMER_NOT_SAME_DOCTOR,
        FOLLOWUP_EXCEPTION
    }

    enum NewsTitle {
        TITLE_WELCOME("TITLE_WELCOME"),
        TITLE_FILL_INFO("TITLE_FILL_INFO"),
        TITLE_COMMUNICATE("TITLE_COMMUNICATE"),
        TITLE_TAKE_CARE_IDONGRI("TITLE_TAKE_CARE_IDONGRI"),
        TITLE_DOWNLOAD("TITLE_DOWNLOAD");
        private String key;

        NewsTitle(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }
    }

    enum Pic {
        PIC_FILL_INFO("PIC_FILL_INFO"),
        PIC_CONTACT("PIC_CONTACT"),
        PIC_IDONGRI("PIC_IDONGRI"),
        PIC_IDONGRI_SMALL("PIC_IDONGRI_SMALL");
        private String key;

        Pic(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }
    }

    enum URL {
        URL_IDONGRI("URL_IDONGRI"),
        URL_DOWNLOAD("URL_DOWNLOAD"),
        URL_MY_DOCTOR("URL_MY_DOCTOR");
        private String key;

        URL(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }
    }

    enum REQ_MESSAGE_TYPE {
        TEXT("text"),           // 请求消息类型：文本
        IMAGE("image"),         // 请求消息类型：图片
        VOICE("voice"),         // 请求消息类型：语音
        LOCATION("location"),   // 请求消息类型：地理位置
        LINK("link"),           // 请求消息类型：链接
        EVENT("event"),         // 请求消息类型：事件推送
        UNKOWN("unkown");
        private String value;

        REQ_MESSAGE_TYPE(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static REQ_MESSAGE_TYPE getMessgeType(String msg) {
            for (REQ_MESSAGE_TYPE type : REQ_MESSAGE_TYPE.values()) {
                if (type.getValue().equals(msg)) {
                    return type;
                }
            }
            return UNKOWN;
        }
    }

    enum REQ_EVENT_TYPE {
        SUBSCRIBE("SUBSCRIBE"),     // 事件类型：subscribe(订阅)
        UNSUBSCRIBE("UNSUBSCRIBE"), // 事件类型：unsubscribe(取消订阅)
        SCAN("SCAN"),               // 事件类型：scan(用户已关注时的扫描带参数二维码)
        LOCATION("LOCATION"),       // 事件类型：LOCATION(上报地理位置)
        CLICK("CLICK"),             // 事件类型：CLICK(自定义菜单)
        UNKOWN("UNKOWN");
        private String value;

        REQ_EVENT_TYPE(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static REQ_EVENT_TYPE getEventType(String msg) {
            for (REQ_EVENT_TYPE type : REQ_EVENT_TYPE.values()) {
                if (type.getValue().equals(msg)) {
                    return type;
                }
            }
            return UNKOWN;
        }
    }

    enum SEND_TYPE {
        SEND("s"),     // 发
        RECEIVE("r"); // 收

        private String value;

        SEND_TYPE(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    enum REPLY_MSG_TYPE {
        TEXT("text"),           // 请求消息类型：文本
        IMAGE("image"),         // 请求消息类型：图片
        VOICE("voice"),         // 请求消息类型：语音
        VIDEO("video"),         // 请求消息类型：视频
        NEWS("news");         // 请求消息类型：图文
        private String value;

        REPLY_MSG_TYPE(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static REQ_MESSAGE_TYPE getMessgeType(String msg) {
            for (REQ_MESSAGE_TYPE type : REQ_MESSAGE_TYPE.values()) {
                if (type.getValue().equals(msg)) {
                    return type;
                }
            }
            return null;
        }
    }
}
