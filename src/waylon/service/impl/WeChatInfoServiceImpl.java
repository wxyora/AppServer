package waylon.service.impl;

import waylon.dao.WeChatInfoDao;
import waylon.domain.WeChatUserDetailInfo;
import waylon.service.WeChatInfoService;

public class WeChatInfoServiceImpl implements WeChatInfoService {
	
	private WeChatInfoDao weChatInfoDao;

	public WeChatInfoDao getWeChatInfoDao() {
		return weChatInfoDao;
	}

	public void setWeChatInfoDao(WeChatInfoDao weChatInfoDao) {
		this.weChatInfoDao = weChatInfoDao;
	}

	@Override
	public int addWeChatUserInfo(WeChatUserDetailInfo detailInfo) {
		return weChatInfoDao.addWeChatInfo(detailInfo);
	}



}
