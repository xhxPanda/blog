package com.xhx.blog.action.artical;

import com.xhx.blog.common.action.BaseAction;
import com.xhx.blog.domain.Artical;
import com.xhx.blog.util.JsonUtil;
import com.xhx.blog.util.SessionConstants;
import com.xhx.blog.util.SystemContext;

public class ArticalAction extends BaseAction<Artical>{
	
	
	private String title;
	private String content;
	private String summary;
	private String coverImg;
	private Long type;
	
	public String save(){
		
		Artical artical = new Artical();
		
		artical.setUser(userService.getUserById(getCurrentUserId()));
		artical.setType(articalTypeService.getArticalTypeById(type));
		
		articalService.save(artical);
		result = JsonUtil.succ();
		
		return SUCCESS;
	}
	
	public String getArticalBy(Long id){
		Artical artical = articalService.getArticalById(id);
		
		try {
			result = JsonUtil.succObject(artical);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS;
	}

	
	//getter&setter
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getSummary() {
		return summary;
	}


	public void setSummary(String summary) {
		this.summary = summary;
	}


	public String getCoverImg() {
		return coverImg;
	}


	public void setCoverImg(String coverImg) {
		this.coverImg = coverImg;
	}


	public Long getType() {
		return type;
	}


	public void setType(Long type) {
		this.type = type;
	}
	
}
