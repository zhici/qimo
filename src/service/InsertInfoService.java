package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.InsertInfoDao;
import pojo.BaseDataPojo;
import pojo.userInfo;
import util.DButil;

public class InsertInfoService {

	public BaseDataPojo<userInfo> insert(String name, String imgurl, String openId) {
		userInfo u = new userInfo();
		u=selectByopenId(openId);
		userInfo userinfo = new userInfo();
		userinfo.setName(name);
		userinfo.setImgurl(imgurl);
		userinfo.setOpenId(openId);
		if(u==null) {
		if(insert(userinfo)) {
			return  new BaseDataPojo<userInfo>("成功",true,userinfo);
		}else {
			return new BaseDataPojo<userInfo>("失败",false,null);
		}}else {
			return new BaseDataPojo<userInfo>("已存在此用户信息",false,null);
		}
		
	}

	

	public boolean insert(userInfo userinfo) {
		Connection conn = DButil.getConnection();
		InsertInfoDao  insertinfodao = new InsertInfoDao(conn);
		try {
			insertinfodao.insert(userinfo);
			conn.commit();
			return true;
		} catch (SQLException e) {
			return false;
		
		}finally {
			if(conn!=null) {
				DButil.closeConnection(conn);
			}
		}
	}

	public BaseDataPojo<userInfo> selectByopenid(String openId) {
		userInfo userinfofb = new userInfo();
		userinfofb.setOpenId(openId);
		if(selectByopenId(openId)!=null) {
			userInfo useri =null;
			useri=selectByopenId(openId);
			return new BaseDataPojo<userInfo>("成功",true,useri);
		}else {
			return new BaseDataPojo<userInfo>("失败",false,null);
		}
		
	}

	public userInfo selectByopenId(String openId) {
		Connection conn = DButil.getConnection();
		InsertInfoDao  insertinfodaofb = new InsertInfoDao(conn);
			 userInfo user=null;
			 user =insertinfodaofb.select(openId);
			 return user;
	}



	public void updataname(String name,String openId) {
		Connection conn = DButil.getConnection();
		InsertInfoDao upataname =new InsertInfoDao(conn);
		upataname.updatanamefb(name,openId);
		try {
			upataname.updatanamefb(name,openId);
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	public void updataimg(String imgurl, String openId) {
		Connection conn = DButil.getConnection();
		InsertInfoDao updataimg =new InsertInfoDao(conn);
		try {
			updataimg.updataimgfb(imgurl,openId);
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
     
}
 
