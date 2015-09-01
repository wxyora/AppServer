package waylon.action;

import waylon.domain.UserInfo;
import waylon.service.UserInfoService;
import waylon.service.impl.UserInfoServiceImpl;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserInfoService infoService = new UserInfoServiceImpl();
		UserInfo userInfo = infoService.getUserInfoByMobile("138");
		System.out.println(userInfo);

	}

}
