package com.xhx.blog.action.user;

import java.io.File;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xhx.blog.common.action.BaseAction;
import com.xhx.blog.domain.User;
import com.xhx.blog.util.JsonUtil;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User>{
	
	private String loginName;
	private String password; 
	
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
		user.setPassword(password);
		
//		String path = ServletActionContext.getServletContext().getRealPath(
//				getSavePath());
//		
//		String filePath = path + "\\" + getFileName();

//		user.setHeadSculpture(filePath);
		 
		if(null==user.getLoginName()||null==user.getPassword()||null==user.getHeadSculpture()){
			result = JsonUtil.fail();
			return ERROR;
		}else{
			userService.save(user);
			result = JsonUtil.succ();
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
	
}
