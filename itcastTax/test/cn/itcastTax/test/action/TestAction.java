package cn.itcastTax.test.action;

import javax.annotation.Resource;

import cn.itcastTax.test.service.TestService;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {
	
	//注入testService Bean
	@Resource
	TestService testService;

	public String excute(){
		testService.say();
		return SUCCESS;
	}
}
