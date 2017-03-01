package cn.itcastTax.test.dao;

import java.io.Serializable;

import cn.itcastTax.test.entity.Person;

public interface TestDao {

	public void save(Person person);
	
	public Person findPerson(Serializable id);
}
