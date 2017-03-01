package cn.itcastTax.test.service;

import java.io.Serializable;

import cn.itcastTax.test.entity.Person;

public interface TestService {
	public void say();
	
	public void save(Person person);
	
	public Person findPerson(Serializable id);
}
