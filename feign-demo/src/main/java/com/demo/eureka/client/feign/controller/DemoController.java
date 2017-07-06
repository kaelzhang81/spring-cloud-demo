package com.demo.eureka.client.feign.controller;

import com.demo.eureka.client.feign.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.eureka.client.feign.service.demo.DemoServiceFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class DemoController {
	
	@Autowired
	private DemoServiceFeignClient demoServiceFeignClient;
	
	@RequestMapping(value = "/call", method = RequestMethod.GET)
	public String info() {
	    User mike = demoServiceFeignClient.greeting("hi", new User("hey", "mike"));
	    User lucy = demoServiceFeignClient.hello("Lucy");
		return "when i say \"hey\" to " + mike.getName() + " and he answered me \"" + mike.getGreeting()
            + "\". then i call " + lucy.getName() + " and she say \"" + lucy.getGreeting() + "\".";
	}

}
