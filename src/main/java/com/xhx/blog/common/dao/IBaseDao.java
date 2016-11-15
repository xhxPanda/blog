package com.xhx.blog.common.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xhx.blog.util.PageModel;

public interface IBaseDao<T> {
	
	 //按照id删除
	 public void delete(long id);
	 
	 //按照对象删除
	 public void delete(T t);
	 
	 //按照id取出对象
	 public T get(Long id);
	 
	 //取出全部对象
	 public List getAll(Class clazz);
	 
	 //取出list对象
	 public <T> List<T> getList(T t);
	 
	 //分页查询
	 public PageModel getPageBySQL(String sql, PageModel pm);
	 
	 //更新
	 public void update(T t);
	 
	 //新增
	 public void save(T t);
	 
	 public Object queryObject(String hql, Object[] args);
	 
	 public Object queryObject(String hql, Map<String, Object> alias);
	 
	 public Object queryObject(String hql, Object[] args, Map<String, Object> alias);
	 
	 /**
		 * 执行HQL语句，查询一组记录
		 * @param hql
		 * @param args 参数，按顺序的
		 * @return 查询结果
		 */
		public List<T> list(String hql, Object[] args);
		
		/**
		 * 执行HQL语句，查询一组记录
		 * @param hql
		 * @param alias 参数，“参数：值”的键值对
		 * @return 查询结果
		 */
		public List<T> list(String hql, Map<String, Object> alias);

		/**
		 * 执行HQL语句，查询一组记录
		 * @param hql
		 * @param args 参数，按顺序的
		 * @param alias 参数，“参数：值”的键值对
		 * @return 查询结果
		 */
		public List<T> list(String hql, Object[] args, Map<String, Object> alias);

	 
}
