package service;



import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;



import dao.UserDao;
import pojo.BaseDataPojo;
import pojo.User;
import util.DButil;


public class UserService {
	public BaseDataPojo<Map<String, Object>> getCredit(int id) {
		User user = selectById(id);
		Map<String, Object> map = new HashMap<>();
		if (user != null) {
			map.put("credit", user.getCredit());
			return new BaseDataPojo<Map<String, Object>>("获取积分成功", true, map);
		} else {
			return new BaseDataPojo<Map<String, Object>>("获取积分失败", false, null);
		}
	}

	public User selectById(int id) {
		Connection conn = DButil.getConnection();
		UserDao userDAO = new UserDao(conn);
		User user = null;
		try {
			user = userDAO.selectById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				DButil.closeConnection(conn);
			}
		}
		return user;
	}
}
