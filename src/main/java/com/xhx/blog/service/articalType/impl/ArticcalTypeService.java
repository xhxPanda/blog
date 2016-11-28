package com.xhx.blog.service.articalType.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.xhx.blog.dao.ArticalTypeDao.IArticalTypeDao;
import com.xhx.blog.domain.ArticalType;
import com.xhx.blog.service.articalType.IArticalTypeService;
import com.xhx.blog.util.PageModel;

public class ArticcalTypeService implements IArticalTypeService {

	@Resource
	IArticalTypeDao articalTypeDao;
	
	public void save(ArticalType at) {
		// TODO Auto-generated method stub
		articalTypeDao.save(at);
	}

	public List<ArticalType> getAll() {
		// TODO Auto-generated method stub
		
		String hql = "from ArticcalType at order by at.id desc";
		return articalTypeDao.list(hql, null,null);
	}

	
}
