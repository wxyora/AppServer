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
		// ͨ������signature���������У�飬��У��ɹ���ԭ������echostr����ʾ����ɹ����������ʧ��
		if (SignUtil.checkSignature(signature, timestamp, nonce)) {
			out.print(echostr);
		}

		// ����parseXml��������������Ϣ
		Map<String, String> requestMap = MessageUtil.parseXml(request);
		String fromUserName = requestMap.get("FromUserName");  
		String toUserName = requestMap.get("ToUserName");  
		// ��Ϣ����  
		String msgType = requestMap.get("MsgType");  
		String Content = requestMap.get("Content");  
		// �ظ��ı���Ϣ  
		TextMessage textMessage = new TextMessage();  
		textMessage.setToUserName(fromUserName);  
		textMessage.setFromUserName(toUserName);  
		textMessage.setCreateTime(new Date().getTime());  
		textMessage.setMsgType(msgType);  

		// �ı���Ϣ  
		if (msgType.equals(MessageUtil.RESP_MESSAGE_TYPE_TEXT)) {  
			if(isMobile(Content)){
				respContent = "���ڷ�����е�openidΪ:"+fromUserName+"\n�����͵��ֻ���Ϊ��"+Content;  
			}else{
				respContent = "�����ֻ��Ÿ�ʽ�Ƿ���ȷ��";  
			}
			
		}  
		// �����ı���Ϣ������  
		textMessage.setContent(respContent);  
		// ���ı���Ϣ����ת����xml  
		respXml = MessageUtil.textMessageToXml(textMessage);  
		out.print(respXml);   
		out.close();
		out = null;

		System.out.println("����openidΪ"+fromUserName+"����Ϣ��"+Content);

		return SUCCESS;
	}

	public  boolean isMobile(String str) {   
		Pattern p = null;  
		Matcher m = null;  
		boolean b = false;   
		p = Pattern.compile("^[1][3,4,5,8][0-9]{9}$"); // ��֤�ֻ���  
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


