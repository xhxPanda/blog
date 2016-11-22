package com.xhx.blog.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * MD5加密工具
 * @author xhx
 *
 */
public class MD5Util {
	public static String encode(String data){
		return DigestUtils.md5Hex(data);
	}
}
