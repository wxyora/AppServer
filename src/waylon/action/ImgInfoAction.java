package waylon.action;

import com.opensymphony.xwork2.ActionSupport;

public class ImgInfoAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String photo;
	private String imgName;
	private String result;
	
	public String uploadImgInfo(){
		result = "1";
		System.out.println("photo:   "+photo);
		System.out.println("imgName:   "+imgName);
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

}
