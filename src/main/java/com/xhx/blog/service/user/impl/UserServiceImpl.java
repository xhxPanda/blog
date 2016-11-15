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
		
		if (null != user && password.equals(MD5Util.encode(user.getPassword()))) {
			return user;
		}
		return null;
	}

	public void delete(long id) {
		// TODO Auto-generated method stub
		iUserDao.delete(id);
	}

	public void delete(User t) {
		// TODO Auto-generated method stub
		iUserDao.delete(t);
	}

	public User get(Long id) {
		// TODO Auto-generated method stub
		return iUserDao.get(id);
	}

	public List getAll(Class clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> List<T> getList(T t) {
		// TODO Auto-generated method stub
		
		iUserDao.getList(t);
		return null;
	}

	public PageModel getPageBySQL(String sql, PageModel pm) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(User user) {
		// TODO Auto-generated method stub
		iUserDao.save(user);
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		iUserDao.update(user);
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		iUserDao.delete(id);
	}
}
