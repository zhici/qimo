package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.InsertInfoService;

/**
 * Servlet implementation class udataName
 */
@WebServlet("/udataName")
public class udataName extends HttpServlet {
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
		String name= req.getParameter("name");// 提取前端提交的数据
	    String openId=req.getParameter("openId");
	    System.out.println(name);
	    InsertInfoService updata = new InsertInfoService();
	    updata.updataname(name,openId);
	
	
	}
}