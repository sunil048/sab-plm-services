package com.sabtok.plm.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//import javax.validation.constraints.NotNull;

//import org.hibernate.validator.NotEmpty;
//import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="SKILLS")
public class Skill implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * Please don't use genratot() in id since its type is String
	 */

	@Column(name="SKILL_SLNO")
	private Integer slNO;
	
	@Id
    @Column(name="SKILL_ID")
	//@NotBlank(message="Id is empty")
	private String id;
	
	@Column(name="NAME")
	//@NotBlank(message="Name is empty.")
	private String name;
	
//	@NotBlank(message="Code is empty.")
	@Column(name="CODE")
	private String code;
	
//	@NotBlank(message="Please select category.")
	@Column(name="CATEGORY")
	private String category;
	public Skill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Skill [slNO=" + slNO + ", id=" + id + ", name=" + name + ", code=" + code + ", category=" + category
				+ "]";
	}

	public Skill(Integer slNO, String id, String name, String code, String category) {
		super();
		this.slNO = slNO;
		this.id = id;
		this.name = name;
		this.code = code;
		this.category = category;
	}

	public Integer getSlNO() {
		return slNO;
	}

	public void setSlNO(Integer slNO) {
		this.slNO = slNO;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	



}
