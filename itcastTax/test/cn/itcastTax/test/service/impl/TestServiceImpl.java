package cn.itcastTax.test.service.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itcastTax.test.dao.TestDao;
import cn.itcastTax.test.entity.Person;
import cn.itcastTax.test.service.TestService;

@Service("testService")
public class TestServiceImpl implements TestService {

	//注入testDao(testDao与testService同在spring容器中)
	@Resource
	TestDao testDao;
	
	@Override
	public void say() {
		System.out.println("实现---------------");
	}

	@Override
	public void save(Person person) {
		testDao.save(person);
	}

	@Override
	public Person findPerson(Serializable id) {
		return testDao.findPerson(id);
	}

}
