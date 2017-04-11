package net.luis.system.action;

/**
*@CreateTime：2017年3月28日 下午5:14:32
*@Author sai.liu
*@ProjectPackage：net.luis.system.action.HomeAction.java
*@Description：
*/

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Results({ 
	@Result(name = "welcome", location = "/include/welcome.jsp"),
	@Result(name = "login", location = "index.action", type = "redirect") })
public class HomeAction extends ActionSupport {
	private static final long serialVersionUID = -2628011648052951372L;

	public String execute() {
		System.out.println("-------welcome---------");
		return "welcome";
	}
}