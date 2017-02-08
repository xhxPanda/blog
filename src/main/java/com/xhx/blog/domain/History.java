package com.xhx.blog.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity(name="b_history")
public class History {
	
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="tag_id")
	private int tagId;
	
	@Column(name="tag_name")
	private String tagName;
	
	private Date time;
	
	@Column(name="artical_id")
	private int articalId;
	
	@Column(name="artical_name")
	private String articalName;
	
	@Column(name="type_id")
	private int typeId;
	
	@Column(name="type_name")
	private int typeName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getArticalId() {
		return articalId;
	}

	public void setArticalId(int articalId) {
		this.articalId = articalId;
	}

	public String getArticalName() {
		return articalName;
	}

	public void setArticalName(String articalName) {
		this.articalName = articalName;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public int getTypeName() {
		return typeName;
	}

	public void setTypeName(int typeName) {
		this.typeName = typeName;
	}
	

}
