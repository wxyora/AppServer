package waylon.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.json.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import waylon.domain.WeChatUserInfo;
import waylon.util.HttpRequestUtil;
import waylon.util.MessageUtil;
import waylon.util.SignUtil;
import waylon.util.TextMessage;

public class WeChatAction extends ActionSupport {

	/**
	 * wxy
	 */
	private static final long serialVersionUID = 1L;
	private String signature;
	private String timestamp;
	private String nonce;
	private String echostr;
	private static final String appid = "wx55ccb70d4c7330aa";
	private static final String secret = "781e0684cedd7aafb609adb7d6d6e1d0";


	public String dealWeChat() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		String respContent = null;  
		String respXml = null;  
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		if (SignUtil.checkSignature(signature, timestamp, nonce)) {
			out.print(echostr);
		}

		//调用parseXml方法解析请求消息
		Map<String, String> requestMap = MessageUtil.parseXml(request);
		String fromUserName = requestMap.get("FromUserName");  
		String toUserName = requestMap.get("ToUserName");  
		String msgType = requestMap.get("MsgType");  
		String content = requestMap.get("Content");  
		String mobile = "";
		String userName ="";
		// 回复文本消息  
		TextMessage textMessage = new TextMessage();  
		textMessage.setToUserName(fromUserName);  
		textMessage.setFromUserName(toUserName);  
		textMessage.setCreateTime(new Date().getTime());  
		textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);  
		// 文本消息  
		if (MessageUtil.RESP_MESSAGE_TYPE_TEXT.equals(msgType)) { 
			//处理用户输入信息
			String[] userinfo = content.split("#");
			if(userinfo!=null &&userinfo.length>1){
				mobile = userinfo[0].trim();
				userName = userinfo[1].trim();
			}
			if(isMobile(mobile) && !userName.isEmpty()){
				String access_token_url = "https://api.weixin.qq.com/cgi-bin/token";
				String user_info_url ="https://api.weixin.qq.com/cgi-bin/user/info";
				//获取access_token
				String access_token_info = HttpRequestUtil.sendGet(access_token_url,"grant_type=client_credential&appid="+appid+"&secret="+secret);
				JSONObject jsonObject = new JSONObject(access_token_info);
				String access_token = jsonObject.getString("access_token");
				//获取用户信息（昵称）
				String user_info = HttpRequestUtil.sendGet(user_info_url, "access_token="+access_token+"&openid="+fromUserName+"&lang=zh_CN");
				JSONObject user_info_json = new JSONObject(user_info);
				String nickname = "";
				if(user_info_json.has("nickname")){
					nickname = user_info_json.getString("nickname");
					WeChatUserInfo weChatUserInfo = new WeChatUserInfo();
					weChatUserInfo.setOpenId(fromUserName);
					weChatUserInfo.setNickname(nickname);
					weChatUserInfo.setMobile(content);
					weChatUserInfo.setUserName(userName);
				}
				//调用接口存储数据，并判断用户是否已经参与过，如果参与过，提示用户等待开奖
				//TODO 调用service

				//如果没有参与过
				respContent = userName+",您已成功参与抽奖活动,谢谢参与！";  
			}else{
				respContent = "您输入的内容为："+content+" 请检查格式是否符合15966666666#张三";  
			}
		}  
		if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)){
			String event = requestMap.get("Event"); 
			String eventKey = requestMap.get("EventKey"); 
			if(MessageUtil.EVENT_TYPE_CLICK.equals(event)){
				if("apply_meterial".equals(eventKey)){
					respContent ="apply_meterial";  
				}else if("common_question".equals(eventKey)){
					respContent ="common_question";  
				}else if("company_brief".equals(eventKey)){
					respContent ="company_brief";  
				}
				else if("contact_us".equals(eventKey)){
					respContent ="contact_us";  
				}
				else if("happy_enjoy".equals(eventKey)){
					respContent ="happy_enjoy";  
				}
			}
		}
		// 设置文本消息的内容  
		textMessage.setContent(respContent);  
		// 将文本消息对象转换成xml  
		respXml = MessageUtil.textMessageToXml(textMessage);  
		// 响应消息  
		out.print(respXml);  
		out.close();  
		return SUCCESS;
	}

	public  boolean isMobile(String str) {   
		Pattern p = null;  
		Matcher m = null;  
		boolean b = false;   
		p = Pattern.compile("^[1][3,4,5,8][0-9]{9}$"); // 验证手机号  
		m = p.matcher(str);  
		b = m.matches();   
		return b;  
	}  

	public String getSignature() {
		return signature;
	}


	public void setSignature(String signature) {
		this.signature = signature;
	}


	public String getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}


	public String getNonce() {
		return nonce;
	}


	public void setNonce(String nonce) {
		this.nonce = nonce;
	}


	public String getEchostr() {
		return echostr;
	}


	public void setEchostr(String echostr) {
		this.echostr = echostr;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}


