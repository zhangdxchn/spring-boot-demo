package com.zhangdxchn.service;

//todo
//import com.idongri.entity.WxMenu;

import com.zhangdxchn.lib.weixin.bean.resp.TextMessage;

public interface IWxMenuService {
    /**
     * 创建菜单-若已创建过则覆盖
     *
     * @return
     */
    Integer recreateMenu();

//	/**
//	 * 获取菜单
//	 * @param key
//	 * @return
//     */
//	WxMenu getMenuByKey(String key);

    /**
     * 回复信息
     *
     * @param eventKey
     * @return
     */
    String getTextReplyByMenuKey(String eventKey, TextMessage textMessage);
}