package pojo;

public class LoginSession {
	private int id;
	private String openId;
	private String token;
	private int userId;
	
	
	public LoginSession() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LoginSession(int id, String openId, String token, int userId) {
		super();
		this.id = id;
		this.openId = openId;
		this.token = token;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

}
