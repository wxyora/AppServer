package waylon.service.impl;


import waylon.dao.UserInfoDao;
import waylon.domain.UserInfo;
import waylon.service.UserInfoService;

public class UserInfoServiceImpl implements UserInfoService {
	
	private UserInfoDao userInfoDao;

	@Override
	public UserInfo getUserInfoByMobile(String mobile) {
		return userInfoDao.getUserByMobile(mobile);
	}

	
	public UserInfoDao getUserInfoDao() {
		return userInfoDao;
	}


	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}


	@Override
	public int addUser(UserInfo userInfo) {
		return userInfoDao.addUser(userInfo);
	}

}
