package com.xhx.blog.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	
	public static Date formate(Date date){
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        // public final String format(Date date)
	     String s = sdf.format(date);
	     
	   
		try {
			 Date d = sdf.parse(s);
			 return d;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	    return null;
	}
	
}
