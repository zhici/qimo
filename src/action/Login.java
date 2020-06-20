package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pojo.BaseDataPojo;
import pojo.LoginSession;
import service.LoginService;
import util.HttpUtil;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Get统一由Post处理
		doPost(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out =resp.getWriter();    //用PrintWriter对象返回数据
		
		// 模拟封装数据，实际开发中应该遵循分层获取数据：action->service->dao->mysql

		String code = req.getParameter("code");	// 提取前端提交的数据
		System.out.println(code);
		//获取小程序官方的appId和appSecret
		String AppID ="wxa82bf8d7887599c0";
		String AppSecret ="467ce9d82598b3bf364b1cd78ff3e435";
		String url = "https://api.weixin.qq.com/sns/jscode2session" + "?appid=" +AppID + "&secret=" + AppSecret + "&js_code=" + code +
				"&grant_type=authorization_code";
		//发送网络请求获取openid.session_key
				HttpUtil httpUtil = new HttpUtil();
				Map<String, String> map = new HashMap<>();
			    String jsonStr = httpUtil.doGet(url, map);
			    // 字符串转换为对象
			    map = new Gson().fromJson(jsonStr, Map.class);
			    String openId = map.get("openid");
			    System.out.println("openId=" + openId);
			    
			    // 生成token，这里使用时间戳，实际开发中推荐用更成熟的机制生成token
			    String token = "token_" + new Date().getTime();
			    System.out.println("token=" + token);
			    
			    //将openid、token插入到数据库表中
			    //调用service层
			    LoginService loginService = new LoginService();
			    BaseDataPojo<LoginSession> basePojo =  loginService.login(openId, token);
			    System.out.println(new Gson(). toJson(basePojo));

		        out.print(new Gson(). toJson(basePojo)); // 转换为Json数据并返回
	}

}


