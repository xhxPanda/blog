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
import com.xhx.blog.util.StringUtil;

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
		Map<String, Object> alias = new HashMap<String, Object>();
		String hql = "from Artical a where a.id= :id";
		alias.put("id", id);
		return (Artical)iArticalDao.queryObject(hql, alias);
	}
	
	public PageModel<Artical> list(User user){
		PageModel<Artical> pager = null;
		if(user.getAuthority() == 0){
			String hql = "from Artical";
			pager = iArticalDao.findByAlias(hql, null);
		}else{
			String hql = "from Artical where userId = ? order by postTime desc";
			Map<String,Object> alias = new HashMap<String,Object>();
			alias.put("id", user.getId());
			pager = iArticalDao.findByAlias(hql, alias);
		}
		return pager;
	}

	public PageModel<Artical> list(Artical artical) {
		// TODO Auto-generated method stub
		
		PageModel<Artical> pager = null;
		
		String hql = "from Artical a where isPass = 1";
		hql+=StringUtil.isNull(artical.getType().toString())?"":" and a.type = "+artical.getType();
		
		
		Map<String,Object> alias = new HashMap<String,Object>();
		if(!StringUtil.isNull(artical.getUser().getId().toString())){
			hql+=" and a.user = ?";
			alias.put("user", artical.getUser());
		}
		
		pager = iArticalDao.findByAlias(hql, alias);
		
		return pager;
	}

}
