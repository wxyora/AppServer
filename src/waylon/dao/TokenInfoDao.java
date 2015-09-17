package waylon.dao;

import waylon.domain.TokenInfo;

public interface TokenInfoDao {

	public TokenInfo getTokenByMobile(String mobile);
	
	public int addToken(TokenInfo tokenInfo);
	
	public int updateTokenByMobile(TokenInfo tokenInfo);
	
}
