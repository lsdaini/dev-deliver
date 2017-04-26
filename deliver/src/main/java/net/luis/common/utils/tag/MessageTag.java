package net.luis.common.utils.tag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import net.luis.common.utils.Constants;
import net.luis.common.utils.SimpleFormat;

/**
 * 前台页面消息标签
 * @author liusai
 */
public class MessageTag extends TagSupport {

	private static final long serialVersionUID = 4312238096213718267L;
	/** 输出类型 */
	private String innerType;

	public String getInnerType() {
		return innerType;
	}

	public void setInnerType(String innerType) {
		this.innerType = innerType;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int doEndTag() throws JspException {
		// 得到
		Object object = pageContext.getRequest().getAttribute(Constants.MESSAGES_KEY);
		if (object != null) {
			List<String> messages = (ArrayList<String>) object;
			try {
				JspWriter out = pageContext.getOut();
				String show = "";
				if (this.innerType != null && !"".equals(this.innerType.trim())) {
					if ("html".equals(this.innerType.trim())) {
						String msg = this.msgsToHtmlString(messages);
						show = this.html(msg);
						
					}else if("showmsg".equals(this.innerType.trim())){
						String msg = this.msgToString(messages);
						show = this.showmsg(msg);
					}
				} else {
					// 默认为alert
					String msg = this.msgsToString(messages);
					show = this.alert(msg);
				}
				out.println(show);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return EVAL_PAGE;
	}

	private String showmsg(String msg) {
		StringBuffer buf = new StringBuffer();
		buf.append("<script type=\"text/javascript\">\r\n");
		buf.append("showMsg('");
		buf.append(SimpleFormat.escape(msg));
		buf.append("');\r\n");
		buf.append("</script>\r\n");
		return buf.toString();
	}

	/**
	 * 将List转换为String
	 */
	private String msgsToString(List<String> messages) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < messages.size(); i++) {
			buf.append(messages.get(i));
			if (i != messages.size() - 1) {
				buf.append("\r\n");
			}
		}
		return buf.toString();
	}
	
	/**
	 * 将List转换为String
	 */
	private String msgToString(List<String> messages) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < messages.size(); i++) {
			buf.append(messages.get(i));
			if (i != messages.size() - 1) {
				buf.append("<br/>");
			}
		}
		return buf.toString();
	}
	

	/**
	 * 将List转换为String
	 */
	private String msgsToHtmlString(List<String> messages) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < messages.size(); i++) {
			if(i==0){
				buf.append("<span style=\"float:left;\">"+messages.get(i));
			}else{
				buf.append("<span style=\"float:left;\">"+i+"、"+messages.get(i));
			}
			if (i != messages.size() - 1) {
				buf.append("</span><br>");
			}
		}
		return buf.toString();
	}
	/**
	 * 写到客户端	 */
	private String html(String msg) {
		StringBuffer buf = new StringBuffer();
		buf.append("<center><div class=\"messages\">\r\n");
		buf.append(msg);
		buf.append("\r\n");
		buf.append("</div></center>\r\n");
		return buf.toString();
	}

	/**
	 * 弹出消息到客户端
	 */
	private String alert(String msg) {
		StringBuffer buf = new StringBuffer();
		buf.append("<script type=\"text/javascript\">\r\n");
		buf.append("alert('");
		buf.append(SimpleFormat.escape(msg));
		buf.append("');\r\n");
		buf.append("</script>\r\n");
		return buf.toString();
	}
}
