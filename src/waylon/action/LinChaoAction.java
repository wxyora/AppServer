package waylon.action;

import com.opensymphony.xwork2.ActionSupport;

import sun.misc.Cache;

public class LinChaoAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String flagParam;

	private String result;

	private Cache cache;

	public String getFlag() throws Exception {
		
		if(cache!=null){
			result = (String)cache.get("linChaoFlag");
		}else{
			result ="缓存中没有值";
		}
		return SUCCESS;
	}

	public String setFlag() throws Exception {
		if(cache==null){
			cache = new Cache();
		}
		cache.put("linChaoFlag", flagParam);
		result = "1";
		return SUCCESS;
	}
	
	public String getFlagParam() {
		return flagParam;
	}

	public void setFlagParam(String flagParam) {
		this.flagParam = flagParam;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}


}
