package com.zhangdxchn.web.base;

/**
 * 返回的 JSON 约定格式
 */
class ResultEntity {
    public int code;
    public String msg;
    public Object data;

    public ResultEntity() {
    }

    public ResultEntity(CodeMsg codeMsg, Object data) {
        this.code = codeMsg.getCode();
        this.msg = codeMsg.getMsg();
        this.data = data;
    }

    public ResultEntity(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 返回状态码 + 返回消息
     */
    public enum CodeMsg {
        SUCCESS(0, "OK"),
        NULL_POINT(10001, "服务器错误"),
        IO_ERROR(10002, "服务器错误"),
        SQL_ERROR(10003, "服务器错误"),
        UNKONwN_ERROR(10000, "未知异常");

        private Integer code;
        private String msg;

        CodeMsg(Integer code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public Integer getCode() {
            return code;
        }


        public String getMsg() {
            return msg;
        }
    }
}