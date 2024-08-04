package com.Rapid.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Rapid.bean.LoggerInfo;
import com.Rapid.bean.UserMasterBean;
import com.Rapid.model.UserMaster;
import com.Rapid.service.EmployeeService;
import com.Rapid.service.UserService;

@Controller
public class EmployeeController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public ModelAndView insertEmployee(@Valid @ModelAttribute("Employee") UserMasterBean employeeBean, BindingResult result) {
		employeeService.addEmployee(employeeBean);
		Map<String, Object> model = new HashMap<String, Object>();
		List<UserMaster> list = employeeService.listEmployee();
		model.put("employees", prepareListofBean2(list));
		model.put("Employee", new UserMaster());
		return new ModelAndView("redirect:/employee_list", model);
	}

	@RequestMapping(value="/employee_list", method = RequestMethod.GET)
	public ModelAndView viewAllEmployee() {
		Map<String, Object> model = new HashMap<String, Object>();
		List<UserMaster> list = employeeService.listEmployee();
		model.put("employees", prepareListofBean2(list));
		return new ModelAndView("employee_list", model);
	}
	
	//for delete
	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(@ModelAttribute("Employee") UserMasterBean employeeBean, BindingResult result) {
		employeeService.deleteEmployee(employeeBean.getUserMasterId());
		Map<String, Object> model = new HashMap<String, Object>();
		List<UserMaster> list = employeeService.listEmployee();
		model.put("employee", null);
		model.put("employees", prepareListofBean2(list));
		return new ModelAndView("redirect:/employee_list");

	}
	
	@RequestMapping(value = "/updateActiveEmployee", method = RequestMethod.GET)
	public ModelAndView updateActiveEmployee(@ModelAttribute("User") UserMasterBean user, BindingResult result) {
		userService.updateActiveUser(user.getUserMasterId());
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");
		if(null != loggerInfo) {
		return new ModelAndView("redirect:/employee_list");}
		return new ModelAndView("redirect:/signin");

	}
	
	//for edit
	@RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	public ModelAndView editEmployee(@ModelAttribute("Employee") UserMasterBean employeeBean, BindingResult result) {
		UserMaster employee = employeeService.getEmployee(employeeBean.getUserMasterId());
		employeeBean.setUserMasterId(employee.getUserMasterId());
		employeeBean.setUserMasterFirstName(employee.getUserMasterFirstName());
		employeeBean.setUserMasterLastName(employee.getUserMasterLastName());
		employeeBean.setUserEmailId(employee.getUserEmailId());
		employeeBean.setUserAddress(employee.getUserAddress());
		employeeBean.setUserContact(employee.getUserContact());
		employeeBean.setUserDOB(employee.getUserDOB());
		employeeBean.setUserPassword(employee.getUserPassword());
		employeeBean.setUserTId(employee.getUserTId());
		employeeBean.setUserSalary(employee.getUserSalary());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employee", employeeBean);
		return new ModelAndView("employee", model);
	}
	
	
	
	
//	private List<UserMasterBean> prepareListofBean(List<UserMaster> emp){
//		List<UserMasterBean> beans = null;
//		if(emp != null && !emp.isEmpty()){
//			beans = new ArrayList<UserMasterBean>();
//			UserMasterBean bean = null;
//			for(UserMaster employee : emp){
//				bean = new UserMasterBean();
//				bean.setUserMasterId(employee.getUserMasterId());
//				bean.setUserMasterFirstName(employee.getUserMasterFirstName());
//				bean.setUserMasterLastName(employee.getUserMasterLastName());
//				bean.setUserEmailId(employee.getUserEmailId());
//				bean.setUserAddress(employee.getUserAddress());
//				bean.setUserContact(employee.getUserContact());
//				bean.setUserDOB(employee.getUserDOB());
//				bean.setUserPassword(employee.getUserPassword());
//				bean.setUserTId(employee.getUserTId());
//				bean.setUserSalary(employee.getUserSalary());
//				beans.add(bean);
//			}
//		}
//		return beans;
//	}
	
	
	private List<UserMasterBean> prepareListofBean2(List<UserMaster> cat) {
		List<UserMasterBean> beans = null;
		if (cat != null && !cat.isEmpty()) {
			beans = new ArrayList<UserMasterBean>();
			UserMasterBean bean = null;
			Iterator itr = cat.iterator();
			while (itr.hasNext()) {
				bean = new UserMasterBean();
				Object[] obj = (Object[]) itr.next();
				
				bean.setUserMasterId(Integer.parseInt(String.valueOf(obj[0])));
				bean.setUserMasterFirstName(String.valueOf(obj[1]));
				bean.setUserMasterLastName(String.valueOf(obj[2]));
				bean.setUserEmailId(String.valueOf(obj[3]));
				bean.setUserAddress(String.valueOf(obj[5]));
				bean.setUserContact(Long.parseLong(String.valueOf(obj[4])));
				bean.setUserPassword(String.valueOf(obj[6]));
				bean.setIsActive(String.valueOf(obj[9]));
				bean.setUserSalary(Integer.parseInt(String.valueOf(obj[10])));
				bean.setUserTId((Integer.parseInt(String.valueOf(obj[8]))));		
				bean.setUserTypeName(String.valueOf(obj[11]));
				SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
			    Date date=null;
				try {
					date = formatter.parse(String.valueOf(obj[7]));
				} catch (ParseException e) {
					
					e.printStackTrace();
				}
				bean.setUserDOB(date);
				beans.add(bean);
			}	
		}
		return beans;
	}
	
	
	
}
