package com.xhx.blog.action.user;

import java.io.File;
import java.util.List;

import net.sf.json.JSONObject;

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
	
	private Long id;
	private String loginName;
	private String password; 
	private String headSculpture;
	private int authority;
	private String summary;
	
	public String login(){
		
		User user = userService.login(loginName, password);
		if(null != user){
			setCurrentUserId(user.getId());
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
		user.setSummary(summary);
		
		if(null==user.getLoginName()||null==user.getPassword()){
			result = JsonUtil.fail();
			return ERROR;
		}else{			
			userService.save(user);
			result = JsonUtil.succ();
		}
		
		return SUCCESS;
	}
	
	public String getAllUsers(){
		
		List<User> userList= userService.getAllUsers();
		
		if(userList.size()!=0){
			try {
				result = JsonUtil.succList(userList);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			result = JsonUtil.fail();
			return ERROR;
		}
		
		
		return SUCCESS;
	}
	
	public String getUserById(){
		User u = userService.getUserById(id);
		if(u!=null){
			
				try {
					result = JsonUtil.succObject(u);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}else{
			result = JsonUtil.fail();
			return ERROR;
		}
		
		
		return SUCCESS;
	}
	
	public String update(){
		User user = new User();
		user.setLoginName(loginName);
		user.setPassword(MD5Util.encode(password));
		user.setHeadSculpture(headSculpture);
		user.setAuthority(authority);
		user.setSummary(summary);
		
		userService.update(user);
		
		result = JsonUtil.succ();
		
		return SUCCESS;
	}

	public String delete(Long id){
		userService.delete(id);
		
		result = JsonUtil.succ();
		
		return SUCCESS;
	}
	
	
	//getter&setter
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

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
