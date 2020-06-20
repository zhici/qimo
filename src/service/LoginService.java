package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.LoginDao;
import dao.UserDao;
import pojo.BaseDataPojo;
import pojo.LoginSession;
import pojo.User;
import util.DButil;


public class LoginService {
	//action->service->dao->mysql
	//Server层处理一些基本业务
	//Dao层进行对数据库的处理

		//处理登录业务
		public BaseDataPojo<LoginSession> login(String openId,String token) {
			//将openId、token插入数据库表中先查询是否存在此openId
			LoginSession loginsession = SelectByOpenId(openId);//接受Dao层查询的数据
			//判断接受数据中是否有值
			if(loginsession != null) { //数据库中已有此openid。这时只需要更新token
				loginsession.setToken(token);//更新token
				if(updata(loginsession)) {   //更新成功，将新的token返回到前段缓存
					return new BaseDataPojo<LoginSession>("登录成功",true,loginsession);
				}else{                                        //更新失败返回错误信息
					return new BaseDataPojo<LoginSession>("登录失败，返回token时错误",false,null);
				}
	      } else {                           //不存在此openid,则先加一个新用户，然后将新用户的id与用户登录表关联
	    	  User user = new User();
	    	  user.setName("新用户_" + token);
	    	  user.setCredit(100);
	    	  int userId =addUser(user);//添加新用户                   将loginsession表跟user表通过id进行关联 userId=id
	    	  if (userId != -1) { // 将userId和openId、token一起插入到数据库表中
					LoginSession loginSession1 = new LoginSession();
					loginSession1.setOpenId(openId);
					loginSession1.setToken(token);
					loginSession1.setUserId(userId);
					if (insert(loginSession1)) { // 新用户添加成功后，插入一条登录信息，关联openId、token及userId
						return new BaseDataPojo<LoginSession>("登录成功", true, loginSession1);
					} else {
						return new BaseDataPojo<LoginSession>("登录失败，添加openId及token时错误", false, null);
					}
				} else {
					return new BaseDataPojo<LoginSession>("登录失败，添加新用户时错误", false, null);
				}
			}
		}
		
		// 查验token是否有效
			public int checkToken(String token) {
				LoginSession loginSession = selectByToken(token);
				if (loginSession != null) { // 数据库查到此token，表示token有效并返回userId
					return loginSession.getUserId();
				} else { // 数据库中没查到此token，表示token过期或者无此记录
					return -1;
				}
			}

			public LoginSession selectByToken(String token) {
				Connection conn = DButil.getConnection();
				LoginDao loginDAO = new LoginDao(conn);
				LoginSession session = null;
				try {
					session = loginDAO.selectByToken(token);
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					if (conn != null) {
						DButil.closeConnection(conn);
					}
				}
				return session;}
		
		public boolean insert(LoginSession loginSession) {
			Connection conn = DButil.getConnection();
			LoginDao loginDAO = new LoginDao(conn);
			try {
				loginDAO.insert(loginSession);
				conn.commit();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				return false;
			} finally {
				if (conn != null) {
					DButil.closeConnection(conn);
				}
			}
		}
		
		
		public int addUser(User user) {
			Connection conn = DButil.getConnection();
			UserDao userDao = new UserDao(conn);
	        try {
				int id = userDao.insert(user);
				conn.commit();
				return id;
			} catch (SQLException e) {
				e.printStackTrace();
				return -1;
			}finally {
				if(conn!=null) {
					DButil.closeConnection(conn);
				}
			}	
			
		}
		//根据openId查询
		public LoginSession SelectByOpenId(String openId) {
			//调用Dao层进行数据库的处理
			Connection conn = DButil.getConnection();
			LoginDao loginDao = new LoginDao(conn);
			LoginSession loginsession = null;
			try {
				loginsession = loginDao.SelectByOpenId(openId);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(conn!=null) {
					DButil.closeConnection(conn);
				}
			}	
			return loginsession;
		}
		//更新数据库表
		public boolean updata(LoginSession loginsession){
			Connection conn = DButil.getConnection();
			LoginDao loginDao = new LoginDao(conn);
			try {
				 loginDao.updata(loginsession);
				 conn.commit();//提交
				 return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
		}finally {
			if(conn!=null) {
				DButil.closeConnection(conn);}
		}
		
		}}
