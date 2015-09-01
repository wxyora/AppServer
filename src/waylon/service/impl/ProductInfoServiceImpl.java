package waylon.service.impl;

import java.util.List;

import waylon.dao.ProductInfoDao;
import waylon.domain.ProductInfo;
import waylon.service.ProductInfoService;

public class ProductInfoServiceImpl implements ProductInfoService {

	private ProductInfoDao productInfoDao;
	public ProductInfoDao getProductInfoDao() {
		return productInfoDao;
	}
	public void setProductInfoDao(ProductInfoDao productInfoDao) {
		this.productInfoDao = productInfoDao;
	}
	@Override
	public List<ProductInfo> getAllProductInfo() {
		return productInfoDao.getAllProdutInfo();
	}

	

}
