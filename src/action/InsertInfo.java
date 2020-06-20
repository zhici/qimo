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
import pojo.userInfo;
import service.InsertInfoService;

/**
 * Servlet implementation class InsertInfo
 */
@WebServlet("/InsertInfo")
public class InsertInfo extends HttpServlet {
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
		String name = req.getParameter("name");	//提取前段提交的数据
		String imgurl = req.getParameter("imgurl");	//提取前段提交的数据
		String openId = req.getParameter("openId");	//提取前段提交的数据
//		System.out.println("name:"+name+" imgurl:"+imgurl+" openId:"+openId);
	    InsertInfoService insertinfoservice=new InsertInfoService();
	    BaseDataPojo<userInfo> basedata=insertinfoservice.insert(name,imgurl,openId);
	    out.print(new Gson(). toJson(basedata)); // 转换为Json数据并返回
	}
}
