package net.luis.system.action;

/**
*@CreateTime：2017年3月28日 下午5:13:11
*@Author sai.liu
*@ProjectPackage：net.luis.system.action.LoginAction.java
*@Description：
*/

import com.opensymphony.xwork2.ActionSupport;

import net.luis.system.service.LogService;
import net.luis.system.service.UserService;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

@Results({ 
	@Result(name = "index", location = "/include/login.jsp"),
	@Result(name = "home", location = "home.action", type = "redirect"),
	@Result(name = "changePassword", location = "/system/changePasswordDialog.jsp") })
public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 2335249692775907284L;

	@Autowired
	private UserService userService;

	@Autowired
	private LogService logService;

	public String doLogin() throws Exception {
		System.out.println("-------dologin---------");
		return "home";
	}

	public String doLogout() {
		return "index";
	}

	public String checkLogin() {
		return null;
	}
	
	public String changePassword() {
		return "changePassword";
	}
}