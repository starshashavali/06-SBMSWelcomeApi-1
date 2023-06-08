package com.cts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.feign.GreetFeignClient;

@RestController
public class WelcomeController {
	@Autowired
	private GreetFeignClient feign;

	@Autowired
	private Environment env;
	
	@GetMapping("/welcome")
	public String getWelcomeMsg() {
		String port = env.getProperty("server.port");
		String greetMsg = feign.invokeGreetMsg();
		return greetMsg+("")+"Hi,Welcome to Ashokit";
	}

}
