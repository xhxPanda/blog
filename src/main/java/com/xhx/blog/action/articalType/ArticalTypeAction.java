package com.xhx.blog.action.articalType;

import com.xhx.blog.common.action.BaseAction;
import com.xhx.blog.domain.ArticalType;
import com.xhx.blog.util.JsonUtil;
import com.xhx.blog.util.MD5Util;

public class ArticalTypeAction extends BaseAction<ArticalType>{
	
	private long id;
	private String name;
	
	public String save(){
		ArticalType type= new ArticalType();
		type.setName(name);
		
		articalTypeService.save(type);
		
		if(name!=null||name!=""){
			result = JsonUtil.succ();
		}else{
			result = JsonUtil.fail();
		}
		
		return SUCCESS;
	}
	
	public String getAllArticalType(){
		try {
			result = JsonUtil.succList(articalTypeService.getAll());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String getArticalTypeById(){
		ArticalType at = articalTypeService.getArticalTypeById(id);
		if(at!=null){
			try {
				result = JsonUtil.succObject(at);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			result = JsonUtil.fail();
			return ERROR;
		}
		
		return SUCCESS;	
	}
	
	public String deleteType(){
		articalTypeService.delete(id);
		
		result = JsonUtil.succ();
		
		return SUCCESS;
	}
	
	public String update(){
		
		ArticalType at = new ArticalType();
		at.setId(id);
		at.setName(name);
		
		articalTypeService.update(at);
		
		result = JsonUtil.succ();
		
		return SUCCESS;
	}
	
	public ArticalType getByName(){
		ArticalType at = articalTypeService.getArticalTypeByName(name);
		
		return at;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
