package com.xhx.blog.action.articalType;

import com.xhx.blog.common.action.BaseAction;
import com.xhx.blog.domain.ArticalType;
import com.xhx.blog.util.JsonUtil;

public class ArticalTypeAction extends BaseAction<ArticalType>{
	
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
	
}
