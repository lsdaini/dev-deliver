package net.luis.common.action;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;

import net.luis.common.dao.Page;

/**
 * @CreateTime：2017年3月28日 下午4:43:04
 * @Author sai.liu
 * @ProjectPackage：net.luis.base.action.BaseAction.java @Description：
 */

public abstract class BaseAction extends ActionSupport{
	private static final long serialVersionUID = -2195179132019926434L;
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	/** 设置page对象* */
	public Page page = new Page(50);
	
	public Page getPage() {
	    if (this.page.getPageSize() < 5) {
	        this.page.setPageSize(10);
	      }
	      return this.page;
	}
	public void setPage(Page page) {
		this.page = page;
	}

	public String message;
	
	public List<Integer> checks;
	
	public List<Integer> getChecks() {
		return checks;
	}
	public Integer[] checkIds;
	
	public Integer[] getCheckIds() {
		return checkIds;
	}
}
