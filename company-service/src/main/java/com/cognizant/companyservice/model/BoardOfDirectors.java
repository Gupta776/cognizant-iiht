package com.cognizant.companyservice.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "board_members")
public class BoardOfDirectors {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bm_id")
	private int id;
	
	@Column(name = "bm_cp_name")
	private String name;
	
//	@ManyToOne
	@Column(name = "bm_cp_id")
	private int company;

	

	public BoardOfDirectors(int id, String name, int company) {
	super();
	this.id = id;
	this.name = name;
	this.company = company;
}

	public BoardOfDirectors() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCompany() {
		return company;
	}

	public void setCompany(int company) {
		this.company = company;
	}

	
	
}