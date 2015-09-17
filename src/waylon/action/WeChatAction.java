package waylon.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import waylon.util.MessageUtil;
import waylon.util.SignUtil;

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
		out.close();
		out = null;

		// ����parseXml��������������Ϣ
		Map<String, String> requestMap = MessageUtil.parseXml(request);
		String fromUserName = requestMap.get("FromUserName");  
		String toUserName = requestMap.get("ToUserName");  
		// ��Ϣ����  
		String msgType = requestMap.get("MsgType");  





		return SUCCESS;
	}

}


