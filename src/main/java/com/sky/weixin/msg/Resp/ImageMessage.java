package com.sky.weixin.msg.Resp;

/**
 * 图片消息
 * 
 * @author skygao
 * @date 2014.10.08*
 */
public class ImageMessage extends BaseMessage {
	// 图片
	private Image Image;

	public Image getImage() {
		return Image;
	}

	public void setImage(Image image) {
		Image = image;
	}
}
