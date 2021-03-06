package com.xhx.blog.service.artical;

import java.util.List;

import com.xhx.blog.domain.Artical;
import com.xhx.blog.domain.User;
import com.xhx.blog.util.PageModel;

public interface IArticalService{
	 
	/**
	 * 新增方法
	 * @param  Artical  新增实体
	 */
	public void save(Artical artical);
	
	 /**
	 * 编辑方法
	 * @param  Artical  编辑实体
	 */
	 public void update(Artical artical);
	 
	 /**
	 * 删除方法
	 * @param Artical  删除实体
	 */
	 public void delete(Long id);
	 
	 /**
	 * 根据id取出对象方法
	 * @param id  按照id取出实体
	 */
	 public Artical getArticalById(Long id);
	 
	 /**
	 * 后台分页查询
	 * @param hql
	 */
	 public PageModel<Artical> list(User user);
	 
	 /**
	 * 展示页分页查询
	 * @param hql
	 */
	 public PageModel<Artical> list();
	 
	 
}
