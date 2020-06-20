package test;

import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.gson.Gson;

import pojo.BaseDataPojo;
import pojo.User;
import service.UserService;

public class userTest extends UserService{
	static UserService us;
	@BeforeClass
	public static void BeforeClassTest() {
		us=new UserService();
	}
	@Before
	public void setUp() throws Exception {
		
	}
	@Test
	public void testuser_casea1() {
		BaseDataPojo<Map<String, Object>> test=us.getCredit(24);
		System.out.println(new Gson(). toJson(test));
	}
	@Test
	public void testuser_casea2() {
		BaseDataPojo<Map<String, Object>> test1=us.getCredit(1);
		System.out.println(new Gson(). toJson(test1));
	}
	@Test
	public void testuser_casea3() {
		User user =us.selectById(24);
		System.out.println(new Gson(). toJson(user));
	}
	@After
	public void tearDown() throws Exception {
		System.out.println("Execute After");
	}

	@AfterClass
	public static void tearDownAfterClass() {
		us = null;
		System.out.println("Execute AfterClass");
	}

}
