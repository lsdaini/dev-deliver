package net.luis.common.utils;

import java.util.Random;

public class StringUtil {

	public static String fmtLong(Long val, int digit) {
		StringBuilder sb = new StringBuilder("");
		sb.append(val);
		if (sb.length() < digit) {
			int cnt = digit - sb.length();
			for (int i = 0; i < cnt; i++) {
				sb.insert(0, "0");
			}
			return sb.toString();
		} else if (sb.length() > digit) {
			return sb.substring(sb.length() - digit, digit);
		} else {
			return sb.toString();
		}
	}

	public static String getToken() {
		Random r = new Random();
		StringBuffer sb = new StringBuffer();
		sb.append(System.currentTimeMillis());
		sb.append("-");
		sb.append(r.nextInt(10000));
		return sb.toString();
	}

	public static String getAutoCode() {
		Random r = new Random();
		StringBuffer sb = new StringBuffer();
		sb.append(System.currentTimeMillis());
		sb.append("-");
		sb.append(r.nextInt(10000));
		return sb.toString();
	}

	public static void main(String args[]) {
		System.out.println(StringUtil.getAutoCode());
	}
}
