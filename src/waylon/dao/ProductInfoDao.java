package waylon.dao;

import java.util.List;

import waylon.domain.PageInfo;
import waylon.domain.ProductInfo;

public interface ProductInfoDao {
	
	public List<ProductInfo> getProdutInfo(PageInfo pageInfo) ;
	
	public int getAllProdutInfoCount() ;

}
