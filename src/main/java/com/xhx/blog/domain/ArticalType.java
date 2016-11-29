package com.xhx.blog.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="articaltype")
public class ArticalType implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@GenericGenerator(name = "generator", strategy = "increment")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="type_id")
	private Set<Artical> artical = new HashSet<Artical>();

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Artical> getArtical() {
		return artical;
	}

	public void setArtical(Set<Artical> artical) {
		this.artical = artical;
	}

}
