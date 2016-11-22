package com.xhx.blog.common.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;

import com.xhx.blog.util.PageModel;

@Repository
public class BaseDao<T>  implements IBaseDao<T>{

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

	public List getAll(Class clazz) {
		// TODO Auto-generated method stub
		return getSession();
	}

	public <T> List<T> getList(T t) {
		// TODO Auto-generated method stub
		return null;
	}

	public PageModel getPageBySQL(String sql, PageModel pm) {
		// TODO Auto-generated method stub
		return null;
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
			return null;
		}
		public List<T> list(String hql, Map<String, Object> alias) {
			// TODO Auto-generated method stub
			return null;
		}
		public List<T> list(String hql, Object[] args, Map<String, Object> alias) {
			// TODO Auto-generated method stub
			return null;
		}
}
