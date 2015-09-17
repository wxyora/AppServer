package waylon.service.impl;


import waylon.dao.TokenInfoDao;
import waylon.domain.TokenInfo;
import waylon.service.TokenInfoService;

public class TokenInfoServiceImpl implements TokenInfoService {
	
	private TokenInfoDao tokenInfoDao;


	@Override
	public TokenInfo getTokenInfoByMobile(String mobile) {
		return tokenInfoDao.getTokenByMobile(mobile);
	}

	@Override
	public int addToken(TokenInfo tokenInfo) {
		return tokenInfoDao.addToken(tokenInfo);
	}

	@Override
	public int updateTokenByMobile(TokenInfo tokenInfo) {
		return tokenInfoDao.updateTokenByMobile(tokenInfo);
	}

	public TokenInfoDao getTokenInfoDao() {
		return tokenInfoDao;
	}
	
	public void setTokenInfoDao(TokenInfoDao tokenInfoDao) {
		this.tokenInfoDao = tokenInfoDao;
	}


}
