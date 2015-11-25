package waylon.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import waylon.domain.PageInfo;
import waylon.domain.ProductInfo;
import waylon.service.ProductInfoService;

public class ProductInfoAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ProductInfoService productInfoService;
	
	private List<ProductInfo>  result;
	private int  pageNo;
	
	public String getProductInfo(){
		int maxNum = productInfoService.getAllProductInfoCount();
		int beginNum = maxNum - (pageNo+1) * 10;
		int endNum = beginNum + 10;
		PageInfo pageInfo = new PageInfo(beginNum,endNum);
		result = productInfoService.getProductInfo(pageInfo);
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

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	


}
