package waylon.service;

import java.util.List;

import waylon.domain.PageInfo;
import waylon.domain.ProductInfo;

public interface ProductInfoService {
	
	public List<ProductInfo> getProductInfo(PageInfo pageInfo);
	
	public int getAllProductInfoCount();

}
