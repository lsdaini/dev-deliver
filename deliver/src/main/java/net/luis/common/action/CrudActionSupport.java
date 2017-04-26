package net.luis.common.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import net.luis.common.dao.Page;
import net.luis.common.utils.Constants;
import net.luis.common.utils.Struts2Utils;

/**
 * Dao抽象类，与数据库相关操作
 * @author liusai
 *
 * @param <T>
 */
public abstract class CrudActionSupport<T> extends ActionSupport implements Constants{
	private static final long serialVersionUID = 8754720155164402291L;
	
	// 存储Action级别消息
	private List<String> messages;
	
	public List<Integer> checks;
	public List<Integer> getChecks() {
		return checks;
	}
	public void setChecks(List<Integer> checks) {
		this.checks = checks;
	}
	
	/**
	 *设置page对象
	 */
	public Page page = new Page(10);
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
	/**
	 * 进行增删改操作后,以redirect方式重新打开action默认页的result名.
	 */
	public static final String RELOAD = "reload";
	
	/**
	 * Action函数, 默认的action函数, 默认调用list()函数.
	 */
	@Override
	public String execute(){
		return list();
	}

	//-- CRUD Action函数 --//
	public abstract String list();
	
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
}
