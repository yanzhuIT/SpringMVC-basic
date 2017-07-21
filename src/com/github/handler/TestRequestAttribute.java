package com.github.handler;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.github.entities.User;

// String.class according to "school"
// this annotation can just put above class, not above method
// @SessionAttributes(value={"user"}, types={String.class}) 
@Controller
public class TestRequestAttribute {

	private static final String SUCCESS = "success";

	@RequestMapping("/testModelAndView")
	public ModelAndView testModelAndView() {
		String viewName = SUCCESS;
		ModelAndView modelAndView = new ModelAndView(viewName);
		modelAndView.addObject("time", new Date());
		return modelAndView;
	}

	@RequestMapping("/testMap")
	public String testMap(Map<String, Object> map) {
		map.put("names", Arrays.asList("Tom", "Cathy", "Allen"));
		System.out.println(map.keySet());
		System.out.println(map.getClass().getName());
		return SUCCESS;
	}

	@RequestMapping("/testSessionAttribute")
	public String testSessionAttribute(Map<String, Object> map) {
		User user = new User("zhu", "123");
		// return value is put into request scope by default
		map.put("user", user);
		map.put("school", "NJIT");
		return SUCCESS;
	}
    
	// simulate: query database by id, and put the value into map of ModelAttribute
	// @ModelAttribute: the method which has this annotation would be invoked before other methods are invoked
	@ModelAttribute
	public void getUser(@RequestParam(value="id",required=false) Integer id,
			 Map<String, Object> map) {
		if(id != null){
		User user = new User(1, "zhu", "123");
		// the key name of the map must be the same to the bean but  the first letter is lowercase
		map.put("user", user);
		System.out.println("user from database: " + user);
		}
	}

	@RequestMapping("/testModelAttribute")
	public String testModelAttribute(User user) {
		System.out.println("new user: " + user);
		return SUCCESS;
	}
	
	@RequestMapping("/testSelfView")
	public String testSelfView(){
		return "helloView";
	}
	
	// redirect in return, forward is the same usage
	@RequestMapping("/testRedirect")
	public String testRedirect(){
		return "redirect:/index_requestAttribute.jsp";
	}
	
	
	 
	
}