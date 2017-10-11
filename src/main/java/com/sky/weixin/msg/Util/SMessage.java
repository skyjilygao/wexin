package com.sky.weixin.msg.Util;

/** 
 * 发送消息类 
 * @author skygao
 * @date 20170411 
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sky.weixin.entity.acttable;
import net.sf.json.JSONArray;

import com.sky.weixin.ParamesAPI.util.AccessToken;
import com.sky.weixin.ParamesAPI.util.ParamesAPI;
import com.sky.weixin.ParamesAPI.util.WeixinUtil;
import com.sky.weixin.msg.Resp.Article;

public class SMessage {
	// 发送接口
	public static String POST_URL = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=ACCESS_TOKEN";

	/**
	 * text消息
	 * 
	 * @param touser
	 *            UserID列表（消息接收者，多个接收者用‘|’分隔）。特殊情况：指定为@all，则向关注该企业应用的全部成员发送————"touser"
	 *            : "UserID1|UserID2|UserID3"
	 * @param toparty
	 *            PartyID列表，多个接受者用‘|’分隔。当touser为@all时忽略本参数————"toparty":
	 *            " PartyID1 | PartyID2 "
	 * @param totag
	 *            TagID列表，多个接受者用‘|’分隔。当touser为@all时忽略本参数————"totag":
	 *            " TagID1 | TagID2 "
	 * @param msgtype
	 *            消息类型，此时固定为：text
	 * @param agentid
	 *            企业应用的id，整型。可在应用的设置页面查看
	 * @param content
	 *            消息内容
	 * @param safe
	 *            表示是否是保密消息，0表示否，1表示是，默认0
	 * */
	public static String STextMsg(String touser, String toparty, String totag,
			String agentid, String content) {
		String PostData = "{\"touser\": %s,\"toparty\": %s,\"totag\": %s,\"msgtype\": \"text\",\"agentid\": %s,\"text\": {\"content\": %s},\"safe\":\"0\"}";
		return String
				.format(PostData, touser, toparty, totag, agentid, content);
	}

	/**
	 * image消息
	 * 
	 * @param touser
	 *            UserID列表（消息接收者，多个接收者用‘|’分隔）。特殊情况：指定为@all，则向关注该企业应用的全部成员发送————"touser"
	 *            : "UserID1|UserID2|UserID3"
	 * @param toparty
	 *            PartyID列表，多个接受者用‘|’分隔。当touser为@all时忽略本参数————"toparty":
	 *            " PartyID1 | PartyID2 "
	 * @param totag
	 *            TagID列表，多个接受者用‘|’分隔。当touser为@all时忽略本参数————"totag":
	 *            " TagID1 | TagID2 "
	 * @param msgtype
	 *            消息类型，此时固定为：image
	 * @param agentid
	 *            企业应用的id，整型。可在应用的设置页面查看
	 * @param media_id
	 *            媒体资源文件ID
	 * @param safe
	 *            表示是否是保密消息，0表示否，1表示是，默认0
	 * */
	public static String SImageMsg(String touser, String toparty,
			String agentid, String media_id) {
		String PostData = "{\"touser\": %s,\"toparty\": %s,\"msgtype\": \"image\",\"agentid\": %s,\"image\": {\"media_id\": %s},\"safe\":\"0\"}";
		return String.format(PostData, touser, toparty, agentid, media_id);
	}

	/**
	 * voice消息
	 * 
	 * @param touser
	 *            UserID列表（消息接收者，多个接收者用‘|’分隔）。特殊情况：指定为@all，则向关注该企业应用的全部成员发送————"touser"
	 *            : "UserID1|UserID2|UserID3"
	 * @param toparty
	 *            PartyID列表，多个接受者用‘|’分隔。当touser为@all时忽略本参数————"toparty":
	 *            " PartyID1 | PartyID2 "
	 * @param totag
	 *            TagID列表，多个接受者用‘|’分隔。当touser为@all时忽略本参数————"totag":
	 *            " TagID1 | TagID2 "
	 * @param msgtype
	 *            消息类型，此时固定为：voice
	 * @param agentid
	 *            企业应用的id，整型。可在应用的设置页面查看
	 * @param media_id
	 *            媒体资源文件ID
	 * @param safe
	 *            表示是否是保密消息，0表示否，1表示是，默认0
	 * */
	public static String SVoiceMsg(String touser, String toparty, String totag,
			String agentid, String media_id) {
		String PostData = "{\"touser\": %s,\"toparty\": %s,\"totag\": %s,\"msgtype\": \"voice\",\"agentid\": %s,\"voice\": {\"media_id\": %s},\"safe\":\"0\"}";
		return String.format(PostData, touser, toparty, totag, agentid,
				media_id);
	}

	/**
	 * video消息
	 * 
	 * @param touser
	 *            UserID列表（消息接收者，多个接收者用‘|’分隔）。特殊情况：指定为@all，则向关注该企业应用的全部成员发送————"touser"
	 *            : "UserID1|UserID2|UserID3"
	 * @param toparty
	 *            PartyID列表，多个接受者用‘|’分隔。当touser为@all时忽略本参数————"toparty":
	 *            " PartyID1 | PartyID2 "
	 * @param totag
	 *            TagID列表，多个接受者用‘|’分隔。当touser为@all时忽略本参数————"totag":
	 *            " TagID1 | TagID2 "
	 * @param msgtype
	 *            消息类型，此时固定为：video
	 * @param agentid
	 *            企业应用的id，整型。可在应用的设置页面查看
	 * @param media_id
	 *            媒体资源文件ID
	 * @param title
	 *            视频消息的标题
	 * @param description
	 *            视频消息的描述
	 * @param safe
	 *            表示是否是保密消息，0表示否，1表示是，默认0
	 */
	public static String SVideoMsg(String touser, String toparty, String totag,
			String agentid, String media_id, String title, String description) {
		String PostData = "{\"touser\": %s,\"toparty\": %s,\"totag\": %s,\"msgtype\": \"video\",\"agentid\": %s,\" video\": {\"media_id\": %s,\"title\": %s,\"description\": %s},\"safe\":\"0\"}";
		return String.format(PostData, touser, toparty, totag, agentid,
				media_id, title, description);
	}

	/**
	 * file消息
	 * 
	 * @param touser
	 *            UserID列表（消息接收者，多个接收者用‘|’分隔）。特殊情况：指定为@all，则向关注该企业应用的全部成员发送————"touser"
	 *            : "UserID1|UserID2|UserID3"
	 * @param toparty
	 *            PartyID列表，多个接受者用‘|’分隔。当touser为@all时忽略本参数————"toparty":
	 *            " PartyID1 | PartyID2 "
	 * @param totag
	 *            TagID列表，多个接受者用‘|’分隔。当touser为@all时忽略本参数————"totag":
	 *            " TagID1 | TagID2 "
	 * @param msgtype
	 *            消息类型，此时固定为：file
	 * @param agentid
	 *            企业应用的id，整型。可在应用的设置页面查看
	 * @param media_id
	 *            媒体资源文件ID
	 * @param safe
	 *            表示是否是保密消息，0表示否，1表示是，默认0
	 * */
	public static String SFileMsg(String touser, String toparty, String totag,
			String agentid, String media_id) {
		String PostData = "{\"touser\": %s,\"toparty\": %s,\"totag\": %s,\"msgtype\": \"file\",\"agentid\": %s,\"file\": {\"media_id\": %s},\"safe\":\"0\"}";
		return String.format(PostData, touser, toparty, totag, agentid,
				media_id);
	}

	/**
	 * news消息 发送对象：touser、toparty、totag。同时给该3个对象发送消息。为空就不发，对象错误就不发
	 * 
	 * @param touser
	 *            UserID列表，就是企业号通讯录中成员账号，不是微信号（消息接收者，多个接收者用‘|’分隔）。特殊情况：指定为@all，
	 *            则向关注该企业应用的全部成员发送————"touser": "UserID1|UserID2|UserID3"
	 * @param toparty
	 *            PartyID列表，部门ID。多个接受者用‘|’分隔。当touser为@all时忽略本参数————"toparty":
	 *            " PartyID1 | PartyID2 "
	 * @param totag
	 *            TagID列表，标签ID。多个接受者用‘|’分隔。当touser为@all时忽略本参数————"totag":
	 *            " TagID1 | TagID2 "
	 * @param msgtype
	 *            消息类型，此时固定为：news
	 * @param agentid
	 *            企业应用的id，整型。可在应用的设置页面查看
	 * @param articlesList
	 *            图文集合
	 */
	public static String SNewsMsg(String touser, String toparty, String totag,
			String agentid, String articlesList) {
		String postData = "{\"touser\": \"%s\",\"toparty\": \"%s\",\"totag\": \"%s\",\"msgtype\": \"news\",\"agentid\": %s,\"news\": {\"articles\":%s}}";
		return String.format(postData, touser, toparty, totag, agentid,
				articlesList);
	}

	/**
	 * mpnews消息
	 * 
	 * @param touser
	 *            UserID列表（消息接收者，多个接收者用‘|’分隔）。特殊情况：指定为@all，则向关注该企业应用的全部成员发送————"touser"
	 *            : "UserID1|UserID2|UserID3"
	 * @param toparty
	 *            PartyID列表，多个接受者用‘|’分隔。当touser为@all时忽略本参数————"toparty":
	 *            " PartyID1 | PartyID2 "
	 * @param totag
	 *            TagID列表，多个接受者用‘|’分隔。当touser为@all时忽略本参数————"totag":
	 *            " TagID1 | TagID2 "
	 * @param msgtype
	 *            消息类型，此时固定为：mpnews
	 * @param agentid
	 *            企业应用的id，整型。可在应用的设置页面查看
	 * @param articlesList
	 *            mpnews集合
	 */
	public static String SMpNewsMsg(String touser, String toparty,
			String totag, String agentid, String articlesList) {
		String postData = "{\"touser\": %s,\"toparty\": %s,\"totag\": %s,\"msgtype\": \"mpnews\",\"agentid\": %s,\"mpnews\": {\"articles\":%s}\"safe\":\"0\"}";
		return String.format(postData, touser, toparty, totag, agentid,
				articlesList);
	}

	// 示例
	public static void main(String[] args) {
		/**
		 * news示例
		 * */
		int sendCount = 1;
		// 调取凭证
		String access_token = WeixinUtil.getAccessToken(ParamesAPI.corpId,ParamesAPI.secret).getToken();
		// 新建图文
		String msg = "hello the first message";
		Article article1 = new Article();
		article1.setTitle("news  ：" + (msg).length() + " 消息发送次数：" + sendCount);
		article1.setDescription(msg);
		article1.setPicUrl("https://work.weixin.qq.com/wework_admin/material/getOpenMsgBuf?type=image&media_id=2SZW2A16iLFZbYbfKF3dseoNf4XepUBvFDBUflcHfnxx-4374TB7JlnVB_06l8ceN&file_name=k.png");//微信接收打不开，
		article1.setUrl("http://www.github.com/skyjilygao");

		// 整合图文
		List<Article> list = new ArrayList<Article>();
		list.add(article1);

		// 图文转json
		String articlesList = JSONArray.fromObject(list).toString();
		// Post的数据，多个用户使用|分开，如"xueruizhi|gao"
		String PostData = SNewsMsg("skyjilygao", "", "", "0", articlesList);
		// String PostData = SNewsMsg("UserID1|UserID2|UserID3",
		// "PartyID1 | PartyID2", "TagID1 | TagID2", "1", articlesList);
		String result = WeixinUtil.PostMessage(access_token, "POST", POST_URL,
				PostData);
		// 打印结果
		if (result == null) {
			sendCount++;
			System.out.println("消息发送成功");
		} else {
			System.out.println("消息发送次数:" + sendCount);
			System.out.println("消息发送失败:Error Msg:" + result);
			// break;
		}
		// }
	}
	public static String sendMessage(acttable acttable){
		acttable.setMess("222");
		acttable.setTarget("skyjilygao");
		int sendCount = 1;
		String retv="1";
		AccessToken accessToken = WeixinUtil.getAccessToken(ParamesAPI.corpId,ParamesAPI.secret); 
		if(accessToken==null){
			retv="0";
		}else{
			String access_token = accessToken.getToken();
			// 新建图文
			Article article1 = new Article();
			article1.setTitle("警告消息提醒");
			article1.setDescription(acttable.getMess());
			// 整合图文
			List<Article> list = new ArrayList<Article>();
			list.add(article1);
			// 图文转json
			String articlesList = JSONArray.fromObject(list).toString();
			String userIdStr=acttable.getTarget();
			String[] userIdArr=userIdStr.split(":");
			String userId="";
			for(int i=0;i<userIdArr.length;i++){
				if(!userIdArr[i].equals("")){
					userId=userId+"|"+userIdArr[i];
				}
			}
			// Post的数据
			String PostData = SNewsMsg(userId, "", "", ParamesAPI.agentid, articlesList);
			String result = WeixinUtil.PostMessage(access_token, "POST", POST_URL,PostData);
			// 打印结果
			if (result == null) {
				sendCount++;
				System.out.println("!!!!! Info:WeChat notification message sent success. "+new Date());
				retv="1";
			} else {
				System.out.println("!!!!! Error:WeChat notification message sent faild. Send Count:"+sendCount+" Error Msg:"+result+" Date:"+new Date());
				retv=result;
			}
		}
		return retv;
	}
}
