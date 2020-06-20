package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pojo.indexData;

public class IndexDataDao {
	 private Connection conn = null;
     private PreparedStatement pst =null;//对数据库的操作
     
     //定义构造函数，实例化时完成注入
     public IndexDataDao(Connection conn) {
    	 super();
    	 this.conn =conn;
     }
     public List<indexData> selectAll(){
    	 String sql="select * from data";
    	 try {
			pst = conn.prepareStatement(sql);
			 ResultSet rs = pst.executeQuery();
	    	 List<indexData> indexdatad=new ArrayList<>();
	    	 while(rs.next()) {
	    		    indexData ind=new indexData();
	    		    ind.setQuestion_id(rs.getInt(1));
	    		    ind.setFeed_source_name(rs.getString(2));
	    		    ind.setFeed_source_text(rs.getString(3));
	    		    ind.setFeed_source_img(rs.getString(4));
	    		    ind.setQuestion(rs.getString(5));
	    		    ind.setAnswer_ctnt(rs.getString(6));
	    		    ind.setGood_num(rs.getInt(7));
	    		    ind.setComment_num(rs.getInt(8));
	    		    indexdatad.add(ind);
	    		   }
	    	 System.out.println(indexdatad);
	    	 return indexdatad;
		} catch (SQLException e) {
			return null;
		}
    	 
    	 }
     }

