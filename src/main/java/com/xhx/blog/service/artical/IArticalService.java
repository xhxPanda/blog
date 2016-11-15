package com.xhx.blog.service.artical;

import java.util.List;

import com.xhx.blog.domain.Artical;

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
	 * 取出所有对象方法
	 * @param Artical  取出实体
	 */
	 public List<Artical> getAll();
	 
	 /**
	 * 取出所有对象方法
	 * @param Artical  按照取出实体
	 */
	 public List<Artical> getArticalAll();
}
