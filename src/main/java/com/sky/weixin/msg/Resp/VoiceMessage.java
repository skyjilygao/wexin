package com.sky.weixin.msg.Resp;

/**
 * 语音消息
 * 
 * @author skygao
 * @date 2014.10.08*
 */
public class VoiceMessage extends BaseMessage {
	// 语音
	private Voice Voice;

	public Voice getVoice() {
		return Voice;
	}

	public void setVoice(Voice voice) {
		Voice = voice;
	}
}
