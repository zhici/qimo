package pojo;

public class userInfo {
    private String name;
    private String imgurl;
    private String openId;
    
	public userInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public userInfo(String name, String imgurl, String openId) {
		super();
		this.name = name;
		this.imgurl = imgurl;
		this.openId = openId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
    
}
