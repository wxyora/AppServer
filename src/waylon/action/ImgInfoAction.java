package waylon.action;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class ImgInfoAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String photo;
	private String imgName;
	private String imgCount;
	private String result;
	private String mobile;
	Map<String, String> resultMap ;
	
	public String uploadImgInfo(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("result",imgCount);
		resultMap = map;
		return SUCCESS;
	}
  

	public String getImgName() {
		return imgName;
	}


	public void setImgName(String imgName) {
		this.imgName = imgName;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getImgCount() {
		return imgCount;
	}


	public void setImgCount(String imgCount) {
		this.imgCount = imgCount;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public Map<String, String> getResultMap() {
		return resultMap;
	}


	public void setResultMap(Map<String, String> resultMap) {
		this.resultMap = resultMap;
	}

}
