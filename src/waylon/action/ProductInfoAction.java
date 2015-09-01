package waylon.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import waylon.domain.ProductInfo;
import waylon.service.ProductInfoService;

public class ProductInfoAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ProductInfoService productInfoService;
	
	private List<ProductInfo>  result;
	
	public String getProductInfo(){
		result = productInfoService.getAllProductInfo();
		return SUCCESS;
	}

	public ProductInfoService getProductInfoService() {
		return productInfoService;
	}

	public void setProductInfoService(ProductInfoService productInfoService) {
		this.productInfoService = productInfoService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<ProductInfo> getResult() {
		return result;
	}

	public void setResult(List<ProductInfo> result) {
		this.result = result;
	}
	


}
