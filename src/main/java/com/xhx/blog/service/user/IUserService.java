package com.xhx.blog.service.user;

import java.util.List;

import com.xhx.blog.domain.User;

public interface IUserService{
	
	/**
	 * 新增方法
	 * @param  user  编辑实体
	 */
	 public void save(User user);
	 
	 /**
	 * 登陆
	 * @param loginName
	 * @param password
	 * @return
	 */	 
	 public User login(String loginName, String password);
	 
	 /**
	 * 取出所有用户
	 * @return
	 */	 
	 public List<User> getAllUsers();
	 
	 /**
	 * 根据id取出用户对象
	 * @return
	 */
	 public User getUserById(Long id);
}
