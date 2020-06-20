package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pojo.BaseDataPojo;
import pojo.LoginSession;
import service.LoginService;


/**
 * Servlet implementation class CheckLogin
 */
@WebServlet("/CheckLogin")
public class CheckLogin extends HttpServlet {
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
		String token = req.getParameter("token");	//提取前段提交的数据	
		LoginService loginService = new LoginService();
		int id = loginService.checkToken(token);
		if(id != -1){		// token有效
			out.print(new Gson().toJson(new BaseDataPojo<LoginSession>("token有效", true, null)));
		}else{			// token无效
			out.print(new Gson().toJson(new BaseDataPojo<LoginSession>("token无效或错误", false, null)));
		};
	}
}
