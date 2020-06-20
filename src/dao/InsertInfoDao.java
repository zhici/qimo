package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.userInfo;

public class InsertInfoDao {
	 private Connection conn = null;
     private PreparedStatement pst =null;//对数据库的操作
     
     //定义构造函数，实例化时完成注入
     public InsertInfoDao(Connection conn) {
    	 super();
    	 this.conn =conn;
     }

	public boolean insert(userInfo userinfo) {
			try {
				String sql = "insert into userInfo(name,imgurl,openId) values(?,?,?)";
				pst = conn.prepareStatement(sql);
				pst.setString(1,userinfo.getName());
				pst.setString(2, userinfo.getImgurl());
				pst.setString(3, userinfo.getOpenId());
				pst.executeUpdate();
	 			return true;
			} catch (SQLException e) {
				
				return false;
			}
		
	}

	public userInfo select(String openId) {
			try {
				String sql = "select * from userInfo where openId=?";
				pst = conn.prepareStatement(sql);
				pst.setString(1, openId);
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
					userInfo us=new userInfo();
					us.setName(rs.getString("name"));
					us.setImgurl(rs.getString("imgurl"));
					us.setOpenId(rs.getString("openId"));
					return us;
				}else {
					return null;
				}
			} catch (SQLException e) {
				
				return null;
			}
			
		
	}

	public void updatanamefb(String name,String openId) {
		userInfo u = new userInfo();
		u.setName(name);
		u.setOpenId(openId);
		
		 try {
			 String sql = "update userInfo set name=? where openId=?";//更新对应openid的name值
			 pst =conn.prepareStatement(sql);
			 pst.setString(1, u.getName());
			 pst.setString(2,u.getOpenId());
			 pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	public void updataimgfb(String imgurl, String openId) {
		userInfo i =new userInfo();
		i.setImgurl(imgurl);
		i.setOpenId(openId);
		try {
			String sql = "update userInfo set imgurl=? where openId=?";//更新对应openid的imgurl值
			pst =conn.prepareStatement(sql);
			 pst.setString(1, i.getImgurl());
			 pst.setString(2,i.getOpenId());
			 pst.executeUpdate();
		} catch (SQLException e) {
			
		}
		
	}
     
}
