package net.luis.system.action;

/**
*@CreateTime：2017年3月28日 下午5:12:26
*@Author sai.liu
*@ProjectPackage：net.luis.system.action.IndexAction.java
*@Description：
*/

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Results;

@Results({ @org.apache.struts2.convention.annotation.Result(name = "login", location = "/include/login.jsp") })
public class IndexAction extends ActionSupport {
	private static final long serialVersionUID = 8033204650474571617L;

	public String execute() throws Exception {
		System.out.println("-------tologin-------");
		return "login";
	}

	@Action("taskAction")
	public String task() throws Exception {
		System.out.println("-------task-------");
		return "task";
	}
}