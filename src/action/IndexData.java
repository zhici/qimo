package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pojo.BaseDataPojo;
import pojo.BaseListPojo;
import pojo.indexData;
import service.IndexDataService;

/**
 * Servlet implementation class IndexData
 */
@WebServlet("/IndexData")
public class IndexData extends HttpServlet {
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
       List<indexData> dataList=new ArrayList<>(); 
       dataList=IndexDataService.selectAll();
       BaseListPojo<indexData> base =new BaseListPojo();
       base.setSuccess(true);
       base.setMsg("成功");
       base.setList(dataList);
       out.print(new Gson(). toJson(base)); // 转换为Json数据并返回
		
	
		
		
		
		
		
		
		
		
		
		
	}
	}