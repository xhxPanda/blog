package com.xhx.blog.common.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;

import com.xhx.blog.util.PageModel;
import com.xhx.blog.util.SystemContext;

@Repository
public class BaseDao<T>  implements IBaseDao<T>{
	
	/**
	 * 默认的页面大小
	 */
	private Integer pageSize;
	/**
	 * 默认的初始页
	 */
	private Integer pageOffset;
	/**
	 * 页面数量
	 */
	private Integer pageCount;


	 @Resource
	 private SessionFactory sessionFactory;
	 
	 private Class<T> clz; // T的Class对象
	 
	 @SuppressWarnings("unchecked")
		private Class<T> getClz() {
			if(null == clz){
				clz = (Class<T>) (((ParameterizedType) (this.getClass()
						.getGenericSuperclass()))
						.getActualTypeArguments()[0]);
			}
			return clz;
		}
    private Session getSession(){
        //获取和当前线程绑定的session
        return sessionFactory.getCurrentSession();
    }

	public void delete(long id) {
		// TODO Auto-generated method stub
		T t = this.get(id);
		
		if(null!=t){
			this.getSession().delete(t);
		}
	}

	public void delete(T t) {
		// TODO Auto-generated method stub
		this.getSession().delete(t);
	}

	public T get(Long id) {
		// TODO Auto-generated method stub
		Session session = getSession();
		return (T) session.get(getClz(), id);
	}
	
	public void update(T t) {
		// TODO Auto-generated method stub
		this.getSession().update(t);
	}

	public void save(T t) {
		// TODO Auto-generated method stub
		this.getSession().save(t);
	}
	
	/**
	 * 执行HQL 语句，查询一条记录
	 * @param hql
	 * @param args 参数，按顺序排列
	 * @return 查询结果
	 */
	public Object queryObject(String hql, Object[] args) {
		return queryObject(hql, args, null);
	}

	/**
	 * 执行HQL语句，查询一条记录
	 * @param hql
	 * @param alias 参数，“参数：值”的键值对
	 * @return 查询结果
	 */
	public Object queryObject(String hql, Map<String, Object> alias) {
		return queryObject(hql, null, alias);
	}
	/**
	 * 执行HQL语句，查询一条记录
	 * @param hql
	 * @param args 参数，按顺序的
	 * @param alias 参数，“参数：值”的键值对
	 * @return 查询结果
	 */
	public Object queryObject(String hql, Object[] args, Map<String, Object> alias) {
		Query query = getSession().createQuery(hql);
		setParameters(query, args);
		setAliasParameters(query, alias);
		return query.uniqueResult();
	}
	
	// 设置参数
		private void setParameters(Query query, Object[] args) {
			if (null != args && args.length > 0) {
				for (int i = 0; i < args.length; i++) {
					query.setParameter(i, args[i]);
				}
			}
		}

		private void setAliasParameters(Query query, Map<String, Object> alias) {
			if (null != alias) {
				Set<String> keys = alias.keySet();
				for (String key : keys) {
					Object obj = alias.get(key);
					if (obj instanceof Collection) {
						query.setParameter(key, (Collection) obj);
					} else {
						query.setParameter(key, obj);
					}
				}
			}
		}
		public List<T> list(String hql, Object[] args) {
			// TODO Auto-generated method stub
			return list(hql, args, null);
		}
		public List<T> list(String hql, Map<String, Object> alias) {
			// TODO Auto-generated method stub
			return list(hql, null, alias);
		}
		public List<T> list(String hql, Object[] args, Map<String, Object> alias) {
			// TODO Auto-generated method stub
			hql = initSort(hql);
			Query query = getSession().createQuery(hql);
			setParameters(query, args);
			setAliasParameters(query, alias);
			return (List<T>) query.list();
		}
		public PageModel<T> find(String hql, Object[] args) {
			// TODO Auto-generated method stub
			return find(hql, args, null);
		}
		public PageModel<T> findByAlias(String hql, Map<String, Object> alias) {
			// TODO Auto-generated method stub
			return find(hql, null, alias);
		}
		public PageModel<T> find(String hql, Object[] args,
				Map<String, Object> alias) {
			// TODO Auto-generated method stub
			hql = initSort(hql);
			String cql = getCountHql(hql, true);
			Query query = getSession().createQuery(hql);
			Query cquery = getSession().createQuery(cql);
			setParameters(query, args);
			setParameters(cquery, args);
			setAliasParameters(query, alias);
			setAliasParameters(cquery, alias);
			PageModel<T> pager = new PageModel<T>();
			setPager(query, pager);
			List<T> result = query.list();
			pager.setRecordList(result); // 页面数据
			Long total = (Long) cquery.uniqueResult();
			pager.setRecordCount(total); // 总记录数
			pager.setPageCount((total + pager.getPageSize() - 1) / pager.getPageSize()); // 总页数
			setPageRange(pager);// 计算页码索引范围
			return pager;
		}
		
		// 初始化HQL语句，增加排序
		private String initSort(String hql) {
			StringBuffer newHql = new StringBuffer(hql);
			// 从SystemContext获取排序方式
			String sort = SystemContext.getSort(); // 排序字段
			String order = SystemContext.getOrder(); // 排序方法

			if (null != sort && !"".equals(order)) {
				newHql.append(" order by ").append(sort);
				if ("desc".equals(order)) {
					newHql.append(" desc");
				} else {
					newHql.append(" asc");
				}
			}
			SystemContext.removeOrder();
			SystemContext.removeSort();
			return newHql.toString();
		}
		
		// 设置分页参数
		private void setPager(Query query, PageModel<T> pager) { 
			Integer pageOffset = SystemContext.getPageOffset();
			Integer pageSize = SystemContext.getPageSize();
			if (null == pageOffset) {
				pageOffset = this.pageOffset;
			}
			if (null == pageSize) {
				pageSize = this.pageSize;
			}
			pager.setCurrentPage(pageOffset);
			pager.setPageSize(pageSize);
			query.setFirstResult((pageOffset - 1) * pageSize).setMaxResults(pageSize);
			SystemContext.removePageSize();
			SystemContext.removePageOffset();
		}
		
		//计算页码范围
		private void setPageRange(PageModel pager) {
			int currentPage = pager.getCurrentPage();
			Long totalPage = pager.getPageCount();
			int beginPageIndex = 0;
			int endPageIndex = 0;
			int total = Integer.valueOf(totalPage.toString());
			if (pageCount > total) {
				beginPageIndex = 1;
				endPageIndex = total;
			} else {
				if (currentPage < pageCount / 2) {
					beginPageIndex = 1;
					endPageIndex = pageCount;
				} else {
					beginPageIndex = currentPage - (pageCount / 2) + 1;
					endPageIndex = beginPageIndex + pageCount - 1;
				}
				if (endPageIndex > pageCount) {
					endPageIndex = pageCount;
					beginPageIndex = endPageIndex - (pageCount - 1);
				}
			}
			pager.setBeginPageIndex(beginPageIndex);
			pager.setEndPageIndex(endPageIndex);
		}
		
		//获得数量
		private String getCountHql(String hql, boolean isHql) {
			String e = hql.substring(hql.indexOf("from"));
			String c = "select  count(*) " + e;
			if (isHql)
				c = c.replaceAll("fetch", "");
			return c;
		}
		
		public Integer getPageSize() {
			return pageSize;
		}
		public void setPageSize(Integer pageSize) {
			this.pageSize = pageSize;
		}
		public Integer getPageOffset() {
			return pageOffset;
		}
		public void setPageOffset(Integer pageOffset) {
			this.pageOffset = pageOffset;
		}
		public Integer getPageCount() {
			return pageCount;
		}
		public void setPageCount(Integer pageCount) {
			this.pageCount = pageCount;
		}
}
