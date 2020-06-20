package test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.gson.Gson;

import pojo.BaseDataPojo;
import pojo.LoginSession;
import pojo.User;
import service.LoginService;

public class loginTest extends LoginService{
	static  LoginService sc;
	@BeforeClass
	public static void BeforeClassTest() {
		sc=new LoginService();
	}
	@Before
	public void setUp() throws Exception {
		
	}
	@Test
	public void testlogin_casea1() {
		BaseDataPojo<LoginSession> test1=sc.login("2","3");
		 System.out.println(new Gson(). toJson(test1));
	}
	@Test
	public void testlogin_case2() {
		BaseDataPojo<LoginSession> test1=sc.login("2","4");
		System.out.println(new Gson(). toJson(test1));
	}
	@Test
	public void testlogin_case3() {
		int except =-1;
		assertEquals( except,sc.checkToken("3"));
	}
	@Test
	public void testlogin_case4() {
		int except =-1;
		assertEquals( except,sc.checkToken("4"));
	}
	@Test
	public void testlogin_case5() {
		int except =25;
		assertEquals( except,sc.checkToken("4"));
	}
	@Test
	public void testlogin_case6() {
		LoginSession lo=sc.selectByToken("4");
		System.out.println(new Gson(). toJson(lo));
	}
	@Test
	public void testlogin_case7() {
		boolean except =true;
		LoginSession loginSession = new LoginSession(25,"3","6",26);
		assertEquals( except,sc.insert(loginSession));
	}
	@Test
	public void testlogin_case8() {
		int except =27;
		User user = new User(27,"张三",100);
		assertEquals( except,sc.addUser(user));
	}
	@Test
	public void testlogin_case9() {
		LoginSession low=sc.SelectByOpenId("24");
		System.out.println(new Gson(). toJson(low));
	}
	@Test
	public void testlogin_case10() {
		boolean except =true;
		LoginSession loginSession = new LoginSession(25,"3","7",26);
		assertEquals( except,sc.updata(loginSession));
	}
	@Test
	public void testlogin_case11() {
		boolean except =true;
		LoginSession loginSession = new LoginSession(25,"3","7",26);
		assertEquals( except,sc.updata(loginSession));
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
