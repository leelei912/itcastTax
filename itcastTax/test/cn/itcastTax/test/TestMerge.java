package cn.itcastTax.test;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcastTax.test.entity.Person;
import cn.itcastTax.test.service.TestService;

public class TestMerge {

	ClassPathXmlApplicationContext ctx;

	@Before
	public void loadCtx() {
		//加载spring容器
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	/**
	 * 测试spring容器是否正常配置
	 */
	@Test
	public void testSpring() {
		//加载spring容器
		TestService ts = (TestService)ctx.getBean("testService");
		ts.say();
	}
	
	@Test
	public void testHibernate() {
		SessionFactory sf = (SessionFactory)ctx.getBean("sessionFactory");
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		//保存人员
		session.save(new Person("人员1"));
		transaction.commit();
		session.close();
	}
	
	@Test
	public void testServiceAndDao() {
		//加载spring容器
		TestService ts = (TestService)ctx.getBean("testService");
		ts.save(new Person("ren2"));
	}
	
	@Test
	public void testTransactionReadOnly() {
		//加载spring容器
		TestService ts = (TestService)ctx.getBean("testService");
//		ts.save(new Person("ren21"));
		System.out.println(ts.findPerson("402881ea5a01d283015a01d284230000").getName());
	}
	
	
}
