package com.xhx.blog.service.artical.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.xhx.blog.dao.artical.IArticalDao;
import com.xhx.blog.dao.user.IUserDao;
import com.xhx.blog.domain.Artical;
import com.xhx.blog.service.artical.IArticalService;
import com.xhx.blog.util.PageModel;

public class ArticalImpl implements IArticalService {
	
	@Resource
	IArticalDao iArticalDao;

	public void save(Artical artical) {
		// TODO Auto-generated method stub
		iArticalDao.save(artical);
	}

	public void update(Artical artical) {
		// TODO Auto-generated method stub
		iArticalDao.update(artical);
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		iArticalDao.delete(id);
	}

	public Artical getArticalById(Long id) {
		// TODO Auto-generated method stub
		return iArticalDao.get(id);
	}

}
