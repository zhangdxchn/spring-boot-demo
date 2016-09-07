package com.zhangdxchn.lib.weixin.bean.req;



/**
 * 文本消息
 * @ClassName: TextMessage 
 * @author zlf 
 * @date 2015年10月23日 上午11:00:43
 */
public class TextMessage extends BaseMessage {

	// 回复的消息内容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}