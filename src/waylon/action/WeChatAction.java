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

import com.opensymphony.xwork2.ActionSupport;

import waylon.util.MessageUtil;
import waylon.util.SignUtil;
import waylon.util.TextMessage;

public class WeChatAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String signature;
	private String timestamp;
	private String nonce;
	private String echostr;


	public String dealWeChat() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		String respContent = null;  
		String respXml = null;  
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		if (SignUtil.checkSignature(signature, timestamp, nonce)) {
			out.print(echostr);
		}

		// 调用parseXml方法解析请求消息
		Map<String, String> requestMap = MessageUtil.parseXml(request);
		String fromUserName = requestMap.get("FromUserName");  
		String toUserName = requestMap.get("ToUserName");  
		// 消息类型  
		String msgType = requestMap.get("MsgType");  
		String Content = requestMap.get("Content");  
		// 回复文本消息  
		TextMessage textMessage = new TextMessage();  
		textMessage.setToUserName(fromUserName);  
		textMessage.setFromUserName(toUserName);  
		textMessage.setCreateTime(new Date().getTime());  
		textMessage.setMsgType(msgType);  

		// 文本消息  
		if (msgType.equals(MessageUtil.RESP_MESSAGE_TYPE_TEXT)) {  
			if(isMobile(Content)){
				respContent = "您在服务号中的openid为:"+fromUserName+"\n您发送的手机号为："+Content;  
			}else{
				respContent = "请检查手机号格式是否正确！";  
			}
			
		}  
		// 设置文本消息的内容  
		textMessage.setContent(respContent);  
		// 将文本消息对象转换成xml  
		respXml = MessageUtil.textMessageToXml(textMessage);  
		out.print(respXml);   
		out.close();
		out = null;

		System.out.println("来自openid为"+fromUserName+"的消息是"+Content);

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


