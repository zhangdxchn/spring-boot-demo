package com.zhangdxchn.lib.weixin.comm;

import com.zhangdxchn.lib.weixin.WeiXinUrls;
import com.zhangdxchn.lib.weixin.bean.menu.Menu;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;


public class MenuUtil {

	private static Logger log = Logger.getLogger(MenuUtil.class);

	/**
	 * 创建菜单
	 */
	public static boolean createMenu(Menu menu, String accessToken) {
		boolean result = false;
		String url = WeiXinUrls.MenuCreateUrl.replace("ACCESS_TOKEN", accessToken);
		// 将菜单对象转换成json字符串
		String jsonMenu = JSONObject.fromObject(menu).toString();
		// 发起POST请求创建菜单
		JSONObject jsonObject = CommonUtil.httpsRequest(url, "POST", jsonMenu);
		System.out.println(jsonObject.toString());
		if (null != jsonObject) {
			int errorCode = jsonObject.getInt("errcode");
			String errorMsg = jsonObject.getString("errmsg");
			if (0 == errorCode) {
				result = true;
			} else {
				result = false;
				log.error("创建菜单失败 errcode:" + errorCode + " errmsg:" + errorMsg);
			}
		}

		return result;
	}

	/**
	 * 查询菜单
	 */
	public static String getMenu(String accessToken) {
		String result = null;
		String requestUrl = WeiXinUrls.MenuGetUrl.replace("ACCESS_TOKEN", accessToken);
		// 发起GET请求查询菜单
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);

		if (null != jsonObject) {
			result = jsonObject.toString();
		}
		return result;
	}

	/**
	 * 删除菜单
	 */
	public static boolean removeMenu(String accessToken) {
		boolean result = false;
		String requestUrl = WeiXinUrls.MenuRemoveUrl.replace("ACCESS_TOKEN", accessToken);
		// 发起GET请求删除菜单
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);

		if (null != jsonObject) {
			int errorCode = jsonObject.getInt("errcode");
			String errorMsg = jsonObject.getString("errmsg");
			if (0 == errorCode) {
				result = true;
			} else {
				result = false;
				log.error("删除菜单失败 errcode:" + errorCode + " errmsg:" + errorMsg);
			}
		}
		return result;
	}
}