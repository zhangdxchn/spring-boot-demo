package com.zhangdxchn.lib.weixin.bean.req;


public class ImageMessage extends BaseMessage {

    private Image Image = new Image();

    private String PicUrl;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public Image getImage() {
        return Image;
    }

    public void setImage(Image image) {
        this.Image = image;
    }
}
