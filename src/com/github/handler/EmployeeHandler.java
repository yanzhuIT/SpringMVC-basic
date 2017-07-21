package com.github.handler;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.dao.DepartmentDao;
import com.github.dao.EmployeeDao;
import com.github.entities.Employee;

@Controller
public class EmployeeHandler {

	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private DepartmentDao departmentDao;
	
    @ModelAttribute
	public void getEmployee(@RequestParam(value="id",required=false) Integer id,
			Map<String, Object> map){
		if(id != null){
			map.put("employee", employeeDao.get(id));
		}
	}
	@RequestMapping(value="/emp", method=RequestMethod.PUT)
	public String update(Employee employee){
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	
	// handle edit request, to edit page
	@RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
	// @PathVariable is for "/" in path, @PathParam is for "?" in path
	public String editEmpPage(@PathVariable("id") Integer id, Map<String, Object> map) {
		// employee data in put into ModelAttribute, then requestScope, for
		// display data before edit
		map.put("employee", employeeDao.get(id));
		map.put("departments", departmentDao.getDepartments());
		// forward to addEmp.jsp
		return "addEmp";
	}

	@RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id) {
		employeeDao.delete(id);
		// redirect to action, display new list
		return "redirect:/emps";
	}

	// action for saving bean to database, method from page is "post"
	@RequestMapping(value = "/emp", method = RequestMethod.POST)
	// @Valid means do all validation of employee
	// bindingResult means result of binding form data with bean data
	public String save(@Valid Employee employee, BindingResult result, Map<String, Object> map) {
		
		if(result.getErrorCount() > 0){
			for(FieldError error : result.getFieldErrors()){
				System.out.println(error.getField() + " : " + error.getDefaultMessage());
			}
			// forward to error page
			map.put("departments", departmentDao.getDepartments());
			return "addEmp";
		}
		employeeDao.save(employee);
		// redirect to action
		return "redirect:/emps";
	}

	// action for adding employee page, "get" department data
	@RequestMapping(value = "/emp", method = RequestMethod.GET)
	// map data will be sent to modelAttribute , and finally to requestScope
	public String addEmpPage(Map<String, Object> map) {
		map.put("departments", departmentDao.getDepartments());
		// must has a bean in requestScope to map details of the bean
		map.put("employee", new Employee());
		// forward to addEmp.jsp
		return "addEmp";
	}

	@RequestMapping("/emps")
	public String list(Map<String, Object> map) {
		map.put("employees", employeeDao.getAll());
		// forward to list.jsp
		return "list";
	}
	
	
	// form data to java bean, method returning is void, parameter is always WebDataBinder
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.setDisallowedFields("lastName");
		
	}

}
