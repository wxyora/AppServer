package waylon.wechat;

public class Article {
    // ͼ����Ϣ����  
    private String Title;  
    // ͼ����Ϣ����  
    private String Description;  
    // ͼƬ���ӣ�֧��JPG��PNG��ʽ���Ϻõ�Ч��Ϊ��ͼ600*300��Сͼ80*80������ͼƬ���ӵ�������Ҫ�뿪������д�Ļ��������е�Urlһ��  
    private String PicUrl;  
    // ���ͼ����Ϣ��ת����  
    private String Url;  
    //ͼ����Ϣ�ľ������ݣ�֧��HTML��ǩ����������2���ַ���С��1M���Ҵ˴���ȥ��JS
    private String Content;
    
	public String getTitle() {  
        return Title;  
    }  
  
    public void setTitle(String title) {  
        Title = title;  
    }  
  
    public String getDescription() {  
        return null == Description ? "" : Description;  
    }  
  
    public void setDescription(String description) {  
        Description = description;  
    }  
  
    public String getPicUrl() {  
        return null == PicUrl ? "" : PicUrl;  
    }  
  
    public void setPicUrl(String picUrl) {  
        PicUrl = picUrl;  
    }  
  
    public String getUrl() {  
        return null == Url ? "" : Url;  
    }  
  
    public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public void setUrl(String url) {  
        Url = url;  
    }  
    

}