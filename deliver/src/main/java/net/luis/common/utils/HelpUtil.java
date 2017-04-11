package net.luis.common.utils;

import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * @CreateTime：2017年3月28日 下午4:54:47
 * @Author sai.liu
 * @ProjectPackage：net.luis.base.utils.HelpUtil.java 
 * @Description：
 */

public class HelpUtil {
	public static Map<String, String> getMapByPorpFile(String filePath) throws ConfigurationException {
		Configuration config = new PropertiesConfiguration(filePath);
		Iterator iter = config.getKeys();
		Map map = new HashMap();
		while (iter.hasNext()) {
			String key = ((String) iter.next()).toString();
			map.put(key, config.getString(key));
		}
		return map;
	}

	public static Map<String, String> getLinkedHashMapByPorpFile(String filePath) throws ConfigurationException {
		Configuration config = new PropertiesConfiguration(filePath);
		Iterator iter = config.getKeys();
		Map map = new LinkedHashMap();
		while (iter.hasNext()) {
			String key = ((String) iter.next()).toString();
			map.put(key, config.getString(key));
		}
		return map;
	}

	public static Map<String, String> getLinkMapByPorpFile(String filePath) throws ConfigurationException {
		Configuration config = new PropertiesConfiguration(filePath);
		Iterator iter = config.getKeys();
		Map map = new LinkedHashMap();
		while (iter.hasNext()) {
			String key = ((String) iter.next()).toString();
			map.put(key, config.getString(key));
		}
		return map;
	}

	public static String getStringByMap(Map map, String spiltchar) {
		if ((map == null) || (map.isEmpty()))
			return null;
		Set keys = map.keySet();
		StringBuffer strBuf = new StringBuffer();
		for (Iterator iter = keys.iterator(); iter.hasNext();) {
			strBuf.append("'" + iter.next() + "'" + spiltchar);
		}
		return strBuf.substring(0, strBuf.length() - 1);
	}

	public static boolean newFolder(String folderPath) {
		try {
			String splitStr = "";
			if (folderPath.indexOf("/") != -1)
				splitStr = "/";
			else
				splitStr = "\\";
			StringTokenizer st = new StringTokenizer(folderPath, splitStr);
			String folder = st.nextToken() + splitStr;
			String subFolder = folder;
			while (st.hasMoreTokens()) {
				folder = st.nextToken() + splitStr;
				subFolder = subFolder + folder;
				File myFilePath = new File(subFolder);
				if (!myFilePath.exists())
					myFilePath.mkdir();
			}
			return true;
		} catch (Exception e) {
			System.out.println("新建目录操作出错");
			e.printStackTrace();
		}
		return false;
	}

	public static void delAllFile(String path) {
		File file = new File(path);
		if (!file.exists()) {
			return;
		}
		if (!file.isDirectory()) {
			return;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator))
				temp = new File(path + tempList[i]);
			else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + "/" + tempList[i]);
				delFolder(path + "/" + tempList[i]);
			}
		}
	}

	public static void delFolder(String folderPath) {
		try {
			delAllFile(folderPath);
			String filePath = folderPath;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			myFilePath.delete();
		} catch (Exception e) {
			System.out.println("删除文件夹操作出错");
			e.printStackTrace();
		}
	}

	public static Property getProperty(Object targetObj, String propertiesName) throws Exception {
		Property properties = new Property();

		properties.setParentClass(targetObj.getClass());

		properties.setName(propertiesName);

		String getName = "get" + propertiesName.substring(0, 1).toUpperCase() + propertiesName.substring(1);

		Method[] methods = targetObj.getClass().getMethods();

		Method method = null;

		for (Method m : methods) {
			if (!m.getName().equalsIgnoreCase(getName))
				continue;
			method = m;

			break;
		}

		if (method == null) {
			return null;
		}
		properties.setType(method.getReturnType().getName());
		try {
			properties.setValue(method.invoke(targetObj, new Object[0]));
		} catch (Exception e) {
			return null;
		}

		return properties;
	}

	public static Date addDayByDate(Date date, int offset) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int day = cal.get(6);
		cal.set(6, day + offset);
		return cal.getTime();
	}

	public static long dateDiff(Date d1, Date d2) {
		long n1 = d1.getTime();
		long n2 = d2.getTime();
		long diff = Math.abs(n1 - n2);
		diff /= 86400000L;
		return diff;
	}

	public static Date addMonthByDate(Date date, int offset) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int day = cal.get(2);
		cal.set(2, day + offset);
		return cal.getTime();
	}

	public static Date getLastDayByMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(5, 1);
		cal.add(2, 1);
		cal.add(5, -1);

		return formatDate(cal.getTime(), "yyyy-MM-dd");
	}

	public static Date getUpLastDayByMonth(Date date) {
		Date date1 = addMonthByDate(date, -1);

		return getLastDayByMonth(date1);
	}

	public static Date formatDate(Date date, String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return strToDate(sdf.format(date), dateFormat);
	}

	public static Date strToDate(String str, String format) {
		SimpleDateFormat dtFormat = null;
		try {
			dtFormat = new SimpleDateFormat(format);

			return dtFormat.parse(str);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static String listToStr(List<String> list, String flagChar) {
		if ((list == null) || (list.size() == 0))
			return null;
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			str.append((String) list.get(i) + flagChar);
		}
		return str.toString().substring(0, str.length() - 1);
	}

	public static List<String> strToList(String str, String flagChar) {
		if ((str == null) || (str.length() == 0))
			return null;
		List list = new ArrayList();
		String[] strArray = str.split(flagChar);
		for (int i = 0; i < strArray.length; i++) {
			list.add(strArray[i]);
		}
		return list;
	}

	public static List mapToList(Map map) {
		if (map == null)
			return null;
		Set keys = map.keySet();
		List list = new ArrayList();
		for (Iterator iter = keys.iterator(); iter.hasNext();) {
			list.add(map.get(iter.next().toString()));
		}
		return list;
	}

	public static List mapToListSort(Map map) {
		if (map == null)
			return null;
		List list = new ArrayList();
		Set keys = map.keySet();
		String[] array = new String[map.size()];
		int i = 0;
		for (Iterator iter = keys.iterator(); iter.hasNext();) {
			array[i] = iter.next().toString();
			i++;
		}
		Arrays.sort(array);
		for (int j = 0; j < array.length; j++)
			list.add(array[j]);
		return list;
	}

	public static void copyProperty(Object targetObj, String propertyName, Object value) throws Exception {
		BeanUtils.copyProperty(targetObj, propertyName, value);
	}

	public static void copyProperties(Object targetObj, Object sourceObj) throws Exception {
		BeanUtils.copyProperties(targetObj, sourceObj);
	}

	public static String getPropertyValue(Object targetObj, String propertyName) throws Exception {
		return BeanUtils.getProperty(targetObj, propertyName);
	}

	public static List getPropertyCollection(Object obj) {
		List list = new ArrayList();
		Field[] f = obj.getClass().getDeclaredFields();
		for (int i = 0; i < f.length; i++) {
			list.add(f[i]);
		}
		return list;
	}

	public static boolean checkChange(Object oldFieldValue, Object newFieldValue) throws Exception {
		boolean result = false;
		if ((newFieldValue == null) && (oldFieldValue != null)) {
			return false;
		}
		if ((newFieldValue != null) && (oldFieldValue == null)) {
			return true;
		}
		if ((newFieldValue != null) && (oldFieldValue != null)) {
			if ((newFieldValue instanceof Date)) {
				Date newValue = (Date) newFieldValue;
				Date oldValue = (Date) oldFieldValue;
				if (newValue.compareTo(oldValue) != 0) {
					return true;
				}
			}
			if ((newFieldValue instanceof BigDecimal)) {
				BigDecimal newValue = (BigDecimal) newFieldValue;
				BigDecimal oldValue = (BigDecimal) oldFieldValue;
				if (newValue.compareTo(oldValue) != 0) {
					return true;
				}
			}
			if ((newFieldValue instanceof String)) {
				String newValue = (String) newFieldValue;
				String oldValue = (String) oldFieldValue;
				if (!newValue.equals(oldValue)) {
					return true;
				}
			}
			if ((newFieldValue instanceof Integer)) {
				Integer newValue = (Integer) newFieldValue;
				Integer oldValue = (Integer) oldFieldValue;
				if (!newValue.toString().equals(oldFieldValue.toString())) {
					return true;
				}
			}
		}

		return result;
	}
}
