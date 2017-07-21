package com.github.handler;


import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.entities.User;

@Controller
@RequestMapping("/springmvc")
public class TestRequestMapping {

	@RequestMapping("/testRequestMapping")
	public String testRequestMapping() {
		return "success";
	}
	
	@RequestMapping(value="/testMethod", method=RequestMethod.POST)
	public String testMethod(){
		return "success";
	}
	
	@RequestMapping(value="/testParamsAndHeaders", params={"username", "age!=10"})
	public String testParamsAndHeaders(){
		return "success";
	}
	
	
	@RequestMapping("/testAntPath/*/abc")
	public String testAntPath(){
		return "success";
	}
	
	@RequestMapping("/testPathVariable/{id}")
	// @PathVariable can map placeholder in path to parameter of target method
	public String testPathVariable(@PathVariable("id") Integer id){
		System.out.println("path variable: " + id);
		return "success";
	}
	
	
	@RequestMapping(value="/testRest/{id}", method=RequestMethod.GET)
	public String testRest(@PathVariable("id") Integer id){
		System.out.println("GET: " + id);
		return "success";
	}
	
	@RequestMapping(value="/testRest", method=RequestMethod.POST)
	public String testRest(){
		System.out.println("POST");
		return "success";
	}
	
	@RequestMapping(value="/testRest/{id}", method=RequestMethod.DELETE)
	public String testRestDelte(@PathVariable("id") Integer id){
		System.out.println("Delete: " + id);
		return "success";
	}
	
	@RequestMapping(value="/testRest/{id}", method=RequestMethod.PUT)
	public String testRestPut(@PathVariable("id") Integer id){
		System.out.println("PUT: " + id);
		return "success";
	}
	
	@RequestMapping(value="/testRequestParam")
	public String testRequestParam(@RequestParam(value="username") String username,
			@RequestParam(value="age", required=false, defaultValue="10000") Integer age){
		System.out.println(username + " and " + age);
		return "success";
	}
	
	@RequestMapping("/testCookieValue")
	public String testCookieValue(@CookieValue("JSESSIONID") String cookieVaule){
		System.out.println(cookieVaule);
		return "success";
	}
	
	@RequestMapping("/testPojo")
	public String testPojo(User user){
		System.out.println(user);
		return "success";
	}
	
	
	@RequestMapping("/testServletAPI")
	public void testServletAPI(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, Writer out) throws Exception{
		System.out.println(httpServletRequest + "  +  " + httpServletResponse);
		out.write("hello springmvc");
		// return "success";
	}

}
