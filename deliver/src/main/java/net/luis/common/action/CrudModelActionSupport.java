package net.luis.common.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import net.luis.common.utils.Constants;
import net.luis.common.utils.Struts2Utils;
@Results( {
	@Result(name =ActionSupport.LOGIN,location="index.action", type = "redirect")})
public abstract class CrudModelActionSupport<T> extends BaseAction implements ModelDriven<T>, Preparable,Constants {
	private static final long serialVersionUID = 8754720155164402291L;
	
	// 存储Action级别消息
	protected List<String> messages;
	
	//	-- 页面属性 --//
	public Integer id;
	public T entity;
	public T getModel() {
		return entity;
	}
	
	public String paramObjs;
	//	-- ModelDriven 与 Preparable函数 --//
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * 进行增删改操作后,以redirect方式重新打开action默认页的result名.
	 */
	public static final String RELOAD = "reload";
	
	/**
	 * Action函数, 默认的action函数, 默认调用list()函数.
	 */
	@Override
	public String execute() throws Exception {
//		User user = SystemUtils.getCurrentUser();
//		if(user==null){
//			return LOGIN;
//		}
		return list();
	}

	//-- CRUD Action函数 --//
	public abstract String list() throws Exception;
	@Override
	public abstract String input() throws Exception;
	public abstract String view() throws Exception;
	public abstract String approve() throws Exception;
	public abstract String save() throws Exception;
	public abstract String delete() throws Exception;
	public  String copyObj() throws Exception{return null;}
	//-- Preparable函数 --//
	/**
	 * 实现空的prepare()函数,屏蔽所有Action函数公共的二次绑定.
	 */
	public void prepare() throws Exception {
		
	}
	/**
	 * 在input()前执行二次绑定.
	 */
	public void prepareInput() throws Exception {
		prepareModel();
	}
	/**
	 * 在view()前执行二次绑定.
	 */
	public void prepareView() throws Exception {
		prepareModel();
	}
	/**
	 * 在approve()前执行二次绑定.
	 */
	public void prepareApprove() throws Exception {
		prepareModel();
	}
	/**
	 * 在save()前执行二次绑定.
	 */
	public void prepareSave() throws Exception {
		prepareModel();
	}
	/**
	 * 在copyObj()前执行二次绑定.
	 */
	public void prepareCopyObj() throws Exception {
		prepareModel();
	}
	/**
	 * 等同于prepare()的内部函数,供prepardMethodName()函数调用. 
	 */
	protected abstract void prepareModel() throws Exception;
	
	/**
	 * Action存储消息
	 * @param message
	 */
	public void addMessage(String message){
		if (message != null && !"".equals(message.trim())) {
			if (this.messages == null) {
				this.messages = new ArrayList<String>();
			}
			// 添加消息
			this.messages.add(message);
		}
		if (this.messages != null && this.messages.size() > 0) {
			Struts2Utils.getRequest().setAttribute(Constants.MESSAGES_KEY, messages);
		}
	}
	public void addMessageList(List<String> message){
		if (message != null) {
			if (this.messages == null) {
				this.messages = new ArrayList<String>();
			}
			// 添加消息
			this.messages.addAll(message);
		}
		if (this.messages != null && this.messages.size() > 0) {
			Struts2Utils.getRequest().setAttribute(Constants.MESSAGES_KEY, messages);
		}
	}

	public String getParamObjs() {
		return paramObjs;
	}

	public void setParamObjs(String paramObjs) {
		this.paramObjs = paramObjs;
	}

	public String getIpAddr(HttpServletRequest request) {
	    String ip = request.getHeader("x-forwarded-for"); 
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	        ip = request.getHeader("Proxy-Client-IP"); 
	    } 
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	        ip = request.getHeader("WL-Proxy-Client-IP"); 
	    } 
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	        ip = request.getRemoteAddr(); 
	    } 
	    return ip; 
	}
	
}
