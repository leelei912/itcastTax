package cn.itcastTax.test.dao.impl;

import java.io.Serializable;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itcastTax.test.dao.TestDao;
import cn.itcastTax.test.entity.Person;

public class TestDaoImpl extends HibernateDaoSupport implements TestDao {

	@Override
	public void save(Person person) {
		getHibernateTemplate().save(person);
	}

	@Override
	public Person findPerson(Serializable id) {
		save(new Person("qiqi"));
		return getHibernateTemplate().get(Person.class, id);
	}

}
