package com.xhx.blog.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="b_user")
public class User implements Serializable{
	
	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name="user_name")
	private String loginName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="head_sculpture")
	private String headSculpture;
	
	@Column(name="u_authority")
	private int authority;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="userId")
	private Set<Artical> artical = new HashSet<Artical>();
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHeadSculpture() {
		return headSculpture;
	}
	public void setHeadSculpture(String headSculpture) {
		this.headSculpture = headSculpture;
	}
	public int getAuthority() {
		return authority;
	}
	public void setAuthority(int authority) {
		this.authority = authority;
	}
	public Set<Artical> getArtical() {
		return artical;
	}
	public void setArtical(Set<Artical> artical) {
		this.artical = artical;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
}
