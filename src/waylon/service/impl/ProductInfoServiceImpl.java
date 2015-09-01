package waylon.service.impl;

import waylon.dao.ProductInfoDao;
import waylon.dao.UserInfoDao;
import waylon.domain.ProductInfo;
import waylon.service.ProductInfoService;

public class ProductInfoServiceImpl implements ProductInfoService {

	private ProductInfoDao productInfoDao;
	@Override
	public ProductInfo getAllProductInfo() {
		return productInfoDao.getAllProdutInfo();
	}

	

}
