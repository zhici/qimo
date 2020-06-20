package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pojo.User;



public class UserDao {
	private Connection conn = null;
    private PreparedStatement pst =null;//对数据库的操作
    
    //定义构造函数，实例化时完成注入
    public UserDao(Connection conn) {
   	 super();
   	 this.conn =conn;
    }
    
    public User selectById(int id) throws SQLException {
		String sql = "select * from user where id=?";
		pst = conn.prepareStatement(sql);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setCredit(rs.getInt("credit"));
			return user;
		} else {
			return null;
		}
	}
	
	public boolean update(User user) {
		try {
			String sql = "update user set name=?,credit=? where id=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, user.getName());
			pst.setInt(2, user.getCredit());
			pst.setInt(3, user.getId());
			pst.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
    
    //增加新用户
   public int insert(User user) {
   	try {
			String sql = "insert into user(id,name,credit) values(?,?,?)";
			pst = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS); //Statement.RETURN_GENERATED_KEYS 返回数据表的主key
			pst.setInt(1, user.getId());
			pst.setString(2, user.getName());
			pst.setInt(3, user.getCredit());
			pst.executeUpdate();
			ResultSet rs = pst.getGeneratedKeys(); //获取主key
			if(rs.next()) {
			   return rs.getInt(1);     //返回主key
			}else {
				return -1;              //插入失败返回-1
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
   	
   	
   	
   	
   	
   	
		
   	
   }
     
}
