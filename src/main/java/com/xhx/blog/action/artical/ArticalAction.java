package com.xhx.blog.action.artical;

import java.util.Date;
import java.util.List;

import org.apache.struts2.json.JSONUtil;

import net.sf.json.JSONObject;

import com.xhx.blog.common.action.BaseAction;
import com.xhx.blog.domain.Artical;
import com.xhx.blog.domain.User;
import com.xhx.blog.util.JsonUtil;
import com.xhx.blog.util.PageModel;
import com.xhx.blog.util.SessionConstants;
import com.xhx.blog.util.StringUtil;
import com.xhx.blog.util.SystemContext;

public class ArticalAction extends BaseAction<Artical>{
	
	private Long articalId;
	private String title;
	private String content;
	private String summary;
	private String coverImg;
	private Long typeId;
	private int pageSize;
	private int pageNum;
	private Long userId;
	
	public String save(){
		
		Artical artical = new Artical();
		
		Date date = new Date();
		
		artical.setPostTime(StringUtil.formate(date));
		artical.setContent(content);
		artical.setTitle(title);
		artical.setCoverImg(coverImg);
		artical.setSummary(summary);
		artical.setUser(userService.getUserById(getCurrentUserId()));
		artical.setType(articalTypeService.getArticalTypeById(typeId));
		
		if(artical.getTitle()==null||artical.getContent()==null){
			result = JsonUtil.fail();
		}else{
			articalService.save(artical);
			result = JsonUtil.succ();
			
		}
		
		return SUCCESS;
	}
	
	public String getArticalById(){
		Artical artical = articalService.getArticalById(articalId);
		
		try {
			result = JsonUtil.succObject(artical);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = JsonUtil.fail();
		}
		
		return SUCCESS;
	}
	
	public String getArticalBack(){
		SystemContext.setPageSize(pageSize);
		SystemContext.setPageOffset(pageNum);
		
		User user = userService.getUserById(getCurrentUserId());
		
		PageModel<Artical> artical= articalService.list(user);
		
		try {
			result = JsonUtil.succObject(artical);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = JsonUtil.fail();
		}
		
		return SUCCESS;
	}
	
	public String getArticalShow(){
		SystemContext.setPageSize(pageSize);
		SystemContext.setPageOffset(pageNum);
		
		PageModel<Artical> artical = articalService.list();
		
		try {
			result = JsonUtil.succObject(artical);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = JsonUtil.fail();
		}
		
		return SUCCESS;
	}
	
	public String update(){
		
		Artical artical = new Artical();
		
		Date date = new Date();
		
		artical.setPostTime(StringUtil.formate(date));
		artical.setContent(content);
		artical.setTitle(title);
		artical.setCoverImg(coverImg);
		artical.setSummary(summary);
		
		if(typeId!=null){
			artical.setType(articalTypeService.getArticalTypeById(typeId));
		}
		
		articalService.update(artical);
		
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

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public Long getArticalId() {
		return articalId;
	}

	public void setArticalId(Long articalId) {
		this.articalId = articalId;
	}
	
}
