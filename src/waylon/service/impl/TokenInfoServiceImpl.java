package waylon.service.impl;


import waylon.dao.TokenInfoDao;
import waylon.domain.TokenInfo;
import waylon.service.TokenInfoService;

public class TokenInfoServiceImpl implements TokenInfoService {
	
	private TokenInfoDao tokenInfoDao;

	public TokenInfoDao getTokenInfoDao() {
		return tokenInfoDao;
	}

	public void setTokenInfoDao(TokenInfoDao tokenInfoDao) {
		this.tokenInfoDao = tokenInfoDao;
	}

	@Override
	public TokenInfo getTokenInfoByMobile(String mobile) {
		TokenInfo tokenInfo = tokenInfoDao.getTokenByMobile(mobile);
		return tokenInfo;
	}

	@Override
	public int addToken(TokenInfo tokenInfo) {
		int addToken = tokenInfoDao.addToken(tokenInfo);
		return addToken;
	}



}
