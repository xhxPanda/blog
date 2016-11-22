package com.xhx.blog.action.user;

import java.io.File;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xhx.blog.common.action.BaseAction;
import com.xhx.blog.domain.User;
import com.xhx.blog.util.JsonUtil;
import com.xhx.blog.util.MD5Util;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User>{
	
	private String loginName;
	private String password; 
	private String headSculpture;
	private int authority;
	
	public String login(){
		
		User user = userService.login(loginName, password);
		if(null != user){
			result = JsonUtil.succ();
		}else{
			result = JsonUtil.fail();
		}
			
		return SUCCESS;
	}
	
	public String addUser(){
		User user = new User();
		user.setLoginName(loginName);
		user.setPassword(MD5Util.encode(password));
		user.setHeadSculpture(headSculpture);
		user.setAuthority(authority);
		
		if(null==user.getLoginName()||null==user.getPassword()){
			result = JsonUtil.fail();
			return ERROR;
		}else{			
			userService.save(user);
			result = JsonUtil.succ();
		}
		
		return SUCCESS;
	}
	
	public String getAllUser(){
		
		List<User> userList= userService.getAll(User.class);
		
		try {
			result = JsonUtil.succList(userList);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getHeadSculpture() {
		return headSculpture;
	}

	public void setHeadSculpture(String headSculpture) {
		this.headSculpture = headSculpture;
	}

	public int getAuthority() {
		return authority;
	}

	public void setAuthority(int authority) {
		this.authority = authority;
	}
	
}
