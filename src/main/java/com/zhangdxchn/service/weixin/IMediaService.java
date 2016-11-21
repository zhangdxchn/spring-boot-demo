package com.zhangdxchn.service.weixin;

import com.zhangdxchn.lib.weixin.bean.MediaImage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IMediaService {
	/**
	 *
	 * @return
     */
	List<MediaImage> getImageList();

	/**
	 * form提交
	 * @param requestUrl
	 * @param file
	 * @return
	 */
	String postMediaFile(String requestUrl, MultipartFile file);

	/**
	 * 获取素材列表
	 * @return
	 */
	List<MediaImage> getImageList(Integer page, Integer total);

	/**
	 * 新增图片
	 * @return
     */
	Integer addImageReplyMessage(String mediaId, String tag);
}