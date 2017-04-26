package net.luis.common.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleFormat {
	
	public static final Pattern PATTERN = Pattern.compile("\\{\\d+\\}");
	
	public static String escape(String source) {
		if (source == null) return "";
		StringBuffer buff = new StringBuffer();
		for (int i = 0; i < source.length(); i++) {
			char ch = source.charAt(i);
			switch (ch) {
			case '"':
				buff.append("\\\"");
				break;
			case '\\':
				buff.append("\\\\");
				break;
			case '\b':
				buff.append("\\b");
				break;
			case '\f':
				buff.append("\\f");
				break;
			case '\n':
				buff.append("\\n");
				break;
			case '\r':
				buff.append("\\r");
				break;
			case '\t':
				buff.append("\\t");
				break;
			default:
				if ((ch >= '\u0000' && ch <= '\u001F') ||
					(ch >= '\u007F' && ch <= '\u009F') ||
					(ch >= '\u2000' && ch <= '\u20FF')) {
					String ss = Integer.toHexString(ch);
					buff.append("\\u");
					for (int k = 0; k < 4 - ss.length(); k++) {
						buff.append('0');
					}
					buff.append(ss.toUpperCase());
				} else {
					buff.append(ch);
				}
			}
		}
		return buff.toString();
	}
	/**
	 * 按指定的参数列表格式化指定的字符串, 如下：

	 * <p>
	 * <code>StringFormat.format("{0}, {1}", new Object[]{"Hello", "World!"})</code>,
	 * </p>
	 * <code>the return value is: Hello, World!</code>
	 * 
	 * @param text
	 *            目标字符串

	 * @param args
	 *            待格式化字符串对应的参数列表
	 * @return 返回格式化后的字符串
	 */
	public static String format(String text, Object... args) {
		Matcher matcher = PATTERN.matcher(text);
		int i = 0;
		while (matcher.find()) {
			text = text.replaceAll("\\{" + i + "\\}", args[i++].toString());
			matcher = PATTERN.matcher(text);
		}
		return text;
	}
	
	/**
	 * 数字转换成字符
	 * 
	 * @param number
	 * @return
	 */
	public static String numberToString(int number) {
		/** 格式化样式 */
		String PATTERN = "00";
		/** DecimalFormat对象 */
		DecimalFormat df = new DecimalFormat(PATTERN);
		return df.format(number);
	}
	
	public static String $(String text) {
		return text == null ? "" : text.trim();
	}
	
	public static String toString(BigDecimal value, int precision) {
		if(null == value){
			return "";
		}
		BigDecimal temp = null;
		temp = round(value, precision);
		if(temp.toString().equals("0E-8")){
    		DecimalFormat df=new DecimalFormat("0.00000000");  
    		return df.format(temp);  
    	}
		return Constants.zero.compareTo(temp) == 0 ? "0" : temp.toString();
	}
	
	public static BigDecimal round(BigDecimal value, int precision){ 
		BigDecimal returnvalue = Constants.zero;
		returnvalue = value.divide(new BigDecimal(1), precision, BigDecimal.ROUND_HALF_UP);//四舍五入
		return returnvalue;
	}
}
