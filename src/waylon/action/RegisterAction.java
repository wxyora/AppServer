package waylon.action;

import com.opensymphony.xwork2.ActionSupport;

import waylon.domain.UserInfo;
import waylon.service.UserInfoService;

public class RegisterAction extends ActionSupport{

	/**
	 * wxy
	 */
	private static final long serialVersionUID = -6292866143864611853L;

	private String userName;
	private String password;
	private String result;
	private String mobile;
	private String FromUserName;
	private String code;
	private String state;
	 
	private UserInfoService userInfoService;
	
	@Override
	public String execute() throws Exception {
		return super.execute();
	}

	public String register() throws Exception {
		
		try {
			UserInfo userInfo = userInfoService.getUserInfoByMobile(mobile);
			if(null == userInfo){
				UserInfo userInfoMO = new UserInfo();
				userInfoMO.setMobile(mobile);
				userInfoMO.setPassword(password);
				int requestCode = userInfoService.addUser(userInfoMO);
				String requestStr = String.valueOf(requestCode);
				if("1".equals(requestStr)){
					result = "1";//成功
				}else{
					result = "0";//失败
				}
			}else{
				result = "2";//已存在
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String findUserByMobile(){
		UserInfo userInfo = userInfoService.getUserInfoByMobile(mobile);
		if(userInfo ==null){
			result = "0";//不存在
		}else{
			result = "1";//存在
		}
		return SUCCESS;
	}
	
	public String loginValidate(){
		
		String openID = FromUserName;
		UserInfo userInfo = userInfoService.getUserInfoByMobile(mobile);
		if(userInfo ==null){
			result = "0";//不存在
		}else{
			if(password.equals(userInfo.getPassword())){
				result = "1";
			}else{
				result = "3";
			}
		}
		return SUCCESS;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
	
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
