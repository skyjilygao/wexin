package com.sky.weixin.msg.Resp;

/**
 * 视频消息
 * 
 * @author skygao
 * @date 2014.10.08*
 */
public class VideoMessage extends BaseMessage {
	// 视频
	private Video Video;

	public Video getVideo() {
		return Video;
	}

	public void setVideo(Video video) {
		Video = video;
	}
}
