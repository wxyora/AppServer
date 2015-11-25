package waylon.domain;

public class PageInfo {
	
	private int beginNum;
	
	private int endNum;

	
	public PageInfo() {
		// TODO Auto-generated constructor stub
	}
	
	public PageInfo(int beginNum,int endNum){
		this.beginNum = beginNum;
		this.endNum = endNum;
	}
	public int getBeginNum() {
		return beginNum;
	}

	public void setBeginNum(int beginNum) {
		this.beginNum = beginNum;
	}

	public int getEndNum() {
		return endNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}
	
	

}
