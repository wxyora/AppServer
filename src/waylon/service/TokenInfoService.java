/**
 * 
 */
/**
 * @author Acer-002
 *
 */
package waylon.service;

import waylon.domain.TokenInfo;

public interface TokenInfoService{
	
	public TokenInfo getTokenInfoByMobile(String mobile);
	
	public int addToken(TokenInfo tokenInfo);

}