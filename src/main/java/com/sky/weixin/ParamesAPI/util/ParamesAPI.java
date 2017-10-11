package com.sky.weixin.ParamesAPI.util;
/**
 * @author Engineer-Jsp
 * @date 2014.09.23
 * 参数API类*/
public class ParamesAPI {
	// token
	public static String token = "WeiXinEnterprises";  
	// 随机戳
	public static String encodingAESKey = "tw8ColhrtDzU6XTHJ2shUeTyuaPQkSzdvD8jYtnTIYf";  
	 //你的企业号ID
	public static String corpId = "wx3749dc2eafb7bbbc";
	// 管理组的凭证密钥，每个secret代表了对应用、通讯录、接口的不同权限；不同的管理组拥有不同的secret
	public static String secret = "D3ZJ9tvoACM_RDQayo0k_kYv3okZGUGfQu2tz6SSnpY";
	// OAuth2 回调地址
	public static String REDIRECT_URI = "";
	//企业应用ID
	public static String agentid = "0";
	
	public String checkCorpIdAndSecret(){
		
		return null;
	}

	public static String getCorpId() {
		return corpId;
	}

	public static void setCorpId(String corpId) {
		ParamesAPI.corpId = corpId;
	}

	public static String getSecret() {
		return secret;
	}

	public static void setSecret(String secret) {
		ParamesAPI.secret = secret;
	}

	public static String getAgentid() {
		return agentid;
	}

	public static void setAgentid(String agentid) {
		ParamesAPI.agentid = agentid;
	}
}
