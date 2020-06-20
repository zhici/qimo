package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pojo.BaseDataPojo;
import util.QiniuUtil;

/**
 * Servlet implementation class TokenGet
 */
@WebServlet("/TokenGet")
public class TokenGet extends HttpServlet {
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
		String key = req.getParameter("key");
		System.out.println("key=" + key);
		Map<String,String> map = new HashMap<>();
		String token = QiniuUtil.getToken(key);
		map.put("token", token);
		if(token != null){
			out.print(new Gson().toJson(new BaseDataPojo<Map<String,String>>("获取token成功", true, map)));
		}else {
			out.print(new Gson().toJson(new BaseDataPojo<Map<String,String>>("获取token失败", true, map)));
		}
	
	
	}
}
