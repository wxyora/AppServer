/**
 * 
 */
/**
 * @author Acer-002
 *
 */
package waylon.service;

import waylon.domain.UserInfo;

public interface UserInfoService{
	
	public UserInfo getUserInfoByMobile(String mobile);
	
	public int addUser(UserInfo userInfo);
	
	
	
	
}