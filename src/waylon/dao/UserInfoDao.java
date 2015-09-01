package waylon.dao;

import waylon.domain.UserInfo;

public interface UserInfoDao {

	public UserInfo getUserByMobile(String mobile);
	public int addUser(UserInfo userInfo);
	
}
