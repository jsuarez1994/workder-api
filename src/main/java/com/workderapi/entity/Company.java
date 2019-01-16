package com.workderapi.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="id_sector")
	private Sector sector;
	
//	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinColumn(name = "company")
//	private List<User> listUsers;
	
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

//	public List<User> getListUsers() {
//		return listUsers;
//	}
//
//	public void setListUsers(List<User> listUsers) {
//		this.listUsers = listUsers;
//	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	

}
