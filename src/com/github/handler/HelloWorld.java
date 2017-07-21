package com.github.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorld {

	// prefix + returnVal + suffix-----/WEB-INF/views/success.jsp
	@RequestMapping("/helloworld")
	public String hello() {
		// System.out.println("Hello World!!");
		return "success";
	}

}
