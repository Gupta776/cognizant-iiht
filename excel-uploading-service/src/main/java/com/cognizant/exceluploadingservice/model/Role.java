package com.cognizant.exceluploadingservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ro_id")
	private int id;
	@Column(name = "ro_name")
	private String name;

	public Role() {
		super();
	}

	public Role(int id, String roleName) {
		super();
		this.id = id;
		this.name = roleName;
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

	public void setName(String roleName) {
		this.name = roleName;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + name + "]";
	}

}