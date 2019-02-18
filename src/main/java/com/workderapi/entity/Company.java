package com.workderapi.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.workderapi.baseEntity.BaseTotalEntity;

@Entity
@Table (name="companys")
public class Company extends BaseTotalEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@NotEmpty
	private String web;
	
	@NotNull
	@NotEmpty
	private String address;
	
	@ManyToOne()
	@JoinColumn(name="id_sector")
	private Sector sector;
	
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<User> listUsers;
	
	/*---------------------GETTERS AND SETTERS---------------------*/

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public List<User> getListUsers() {
		return listUsers;
	}

	public void setListUsers(List<User> listUsers) {
		this.listUsers = listUsers;
	}

	public void addUser(User user) {
		this.listUsers.add(user);
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	

}
