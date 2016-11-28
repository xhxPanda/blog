package com.xhx.blog.common.action;

import java.lang.reflect.ParameterizedType;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xhx.blog.service.artical.IArticalService;
import com.xhx.blog.service.articalType.IArticalTypeService;
import com.xhx.blog.service.user.IUserService;
import com.xhx.blog.util.SessionConstants;
import com.xhx.blog.util.GetModelByJson;

/**
 * Action基础类
 * @author xhx
 *
 * @param <T>
 */
public class BaseAction<T> extends ActionSupport implements ServletRequestAware, ServletResponseAware,
SessionAware{

    protected T model;
	
	private Class<T> clz;
	
	public BaseAction(){
		try{
			ParameterizedType pt = (ParameterizedType)this.getClass().getGenericSuperclass();
			clz = (Class<T>)pt.getActualTypeArguments()[0];
			model = clz.newInstance();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected Map<String, Object> session;

	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}

	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}
	
	public T getModel() {
		return this.model;
	}
	
	protected Object getAttributeBySession(String key) {
		return session.get(key);
	}

	// 返回的json对象
	protected JSONObject result = new JSONObject();

	// 用于返回结果集
	public JSONObject getResult() {
		return result;
	}

	// 返回list 的json对象
	protected JSONArray resultList = new JSONArray();

	public JSONArray getResultList() {
		return resultList;
	}
	
	protected void removeUserFromSession(){
		session.remove(SessionConstants.USER_ID);
		session.remove(SessionConstants.MEMBER_ID);
		session.remove(SessionConstants.ORG_ID);
		session.remove(SessionConstants.ROLE);
	}
	
	protected long getCurrentUserId(){
		return (Long) session.get(SessionConstants.USER_ID);
	}
	
	protected void setCurrentUserId(long userId){
		session.put(SessionConstants.USER_ID, userId);
	}
	
	@Resource
	protected IUserService userService;
	
	@Resource
	protected IArticalTypeService articalTypeService;
	
	@Resource
	protected IArticalService articalService;

	
	//set and get
	public Class<T> getClz() {
		return clz;
	}

	public void setClz(Class<T> clz) {
		this.clz = clz;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setModel(T model) {
		this.model = model;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}

	public void setResultList(JSONArray resultList) {
		this.resultList = resultList;
	}
}
