package com.xhx.blog.service.articalType;

import java.util.List;

import com.xhx.blog.domain.ArticalType;

public interface IArticalTypeService {
	
	public void save (ArticalType at);
	
	public List<ArticalType> getAll ();
	
	public ArticalType getArticalTypeById(Long id);
}
