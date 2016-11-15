package com.xhx.blog.util;

public class StringUtil {
	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isNull(String str){
		if(str==null || "".equals(str))
			return true;
		return false;
	}
	
}
