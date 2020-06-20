package service;

import java.sql.Connection;
import java.util.List;

import dao.IndexDataDao;
import pojo.indexData;
import util.DButil;

public class IndexDataService {
	
         public static  List<indexData> selectAll(){
        	 Connection conn = DButil.getConnection();
        	 IndexDataDao indexdao=new IndexDataDao(conn);
        	 List<indexData> indexdata=null;
        	 indexdata=indexdao.selectAll();
        	 return indexdata;
         }
}
