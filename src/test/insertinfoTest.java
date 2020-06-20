package test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.gson.Gson;

import pojo.BaseDataPojo;
import pojo.userInfo;
import service.InsertInfoService;

public class insertinfoTest extends InsertInfoService{
	static InsertInfoService in;
	@BeforeClass
	public static void BeforeClassTest() {
		in = new InsertInfoService();
	}
	@Before
	public void setUp() throws Exception {
		
	}
	@Test
	public void testinsertinfo_casea1() {
		BaseDataPojo<userInfo> e=in.insert("1","2","3");
		System.out.println(new Gson(). toJson(e));
	}
	@Test
	public void testinsertinfo_casea2() {
		boolean except=true;
		userInfo w =new userInfo("2","3","4");
		assertEquals( except,in.insert(w));
	}
	@Test
	public void testinsertinfo_casea3() {
		boolean except=true;
		userInfo w =new userInfo("3","1","9");
		assertEquals( except,in.insert(w));
	}
	@Test
	public void testinsertinfo_casea4() {
		BaseDataPojo<userInfo> o =in.selectByopenid("3");
		System.out.println(new Gson(). toJson(o));
	}
	@Test
	public void testinsertinfo_casea5() {
		BaseDataPojo<userInfo> o =in.selectByopenid("89");
		System.out.println(new Gson(). toJson(o));
	}
	@Test
	public void testinsertinfo_casea6() {
		userInfo q =in.selectByopenId("3");
		System.out.println(new Gson(). toJson(q));
	}
	@Test
	public void testinsertinfo_casea7() {
		userInfo q =in.selectByopenId("8");
		System.out.println(new Gson(). toJson(q));
	}
	@After
	public void tearDown() throws Exception {
		System.out.println("Execute After");
	}

	@AfterClass
	public static void tearDownAfterClass() {
		in = null;
		System.out.println("Execute AfterClass");
	}

}
