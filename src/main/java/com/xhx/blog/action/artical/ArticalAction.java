package com.xhx.blog.action.artical;

import com.xhx.blog.common.action.BaseAction;
import com.xhx.blog.domain.Artical;
import com.xhx.blog.util.JsonUtil;

public class ArticalAction extends BaseAction<Artical>{
	
	
	public String save(){
		
		
		result = JsonUtil.succ();
		
		return SUCCESS;
	}
	
}
