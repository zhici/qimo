package pojo;

public class User {
	private int id;
	private String name;
	private int credit;//用户积分
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String name, int credit) {
		super();
		this.id = id;
		this.name = name;
		this.credit = credit;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	
}
