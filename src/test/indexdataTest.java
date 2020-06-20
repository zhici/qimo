package test;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.gson.Gson;

import pojo.indexData;
import service.IndexDataService;
import service.LoginService;

public class indexdataTest extends IndexDataService{
	static  IndexDataService sc;
	@BeforeClass
	public static void BeforeClassTest() {
		sc=new IndexDataService();
	}
	@Before
	public void setUp() throws Exception {
		
	}
	@Test
	public void testindexdata_casea1() {
		List<indexData> indexdata=null;
		indexdata=sc.selectAll();
		System.out.println(new Gson(). toJson(indexdata));
	}
	@After
	public void tearDown() throws Exception {
		System.out.println("Execute After");
	}

	@AfterClass
	public static void tearDownAfterClass() {
		sc = null;
		System.out.println("Execute AfterClass");
	}

}
