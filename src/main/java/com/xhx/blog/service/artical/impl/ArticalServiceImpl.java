package com.xhx.blog.service.artical.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xhx.blog.dao.artical.IArticalDao;
import com.xhx.blog.domain.Artical;
import com.xhx.blog.domain.User;
import com.xhx.blog.service.artical.IArticalService;
import com.xhx.blog.util.PageModel;

@Transactional
@Service("articcalService")
public class ArticalServiceImpl implements IArticalService {
	
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
	
	public PageModel<Artical> list(User user){
		PageModel<Artical> pager = null;
		if(user.getAuthority() == 0){
			String hql = "from Artical order by postTime desc";
			pager = iArticalDao.findByAlias(hql, null);
		}else{
			String hql = "from Artical where userId = ? order by postTime desc";
			Map<String,Object> alias = new HashMap<String,Object>();
			alias.put("id", user.getId());
			pager = iArticalDao.findByAlias(hql, alias);
		}
		return null;
	}

	public PageModel<Artical> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
