package com.xhx.blog.service.user.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xhx.blog.dao.user.IUserDao;
import com.xhx.blog.domain.User;
import com.xhx.blog.service.user.IUserService;
import com.xhx.blog.util.PageModel;
import com.xhx.blog.util.MD5Util;
import com.xhx.blog.util.SystemContext;

@Transactional
@Service("userService")
public class UserServiceImpl  implements IUserService{
	
	@Resource
	IUserDao iUserDao;
	
	public User login(String loginName, String password) {
		Map<String, Object> alias = new HashMap<String, Object>();
		String hql = "from User u where u.loginName= :loginName"; // 账号登陆
		alias.put("loginName", loginName);
		User user = (User) iUserDao.queryObject(hql, alias);
		
		if (null != user && MD5Util.encode(password).equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	public void save(User user) {
		// TODO Auto-generated method stub
		iUserDao.save(user);
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		
		String hql = "from User u order by id desc";
		return iUserDao.list(hql, null,null);
	}
	
	public User getUserById(Long id){
		Map<String, Object> alias = new HashMap<String, Object>();
		String hql = "from User u where u.id= :id";
		alias.put("id", id);
		return (User)iUserDao.queryObject(hql, alias);
		
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		user.setPassword(MD5Util.encode(user.getPassword()));
		iUserDao.update(user);
	}
	
}
