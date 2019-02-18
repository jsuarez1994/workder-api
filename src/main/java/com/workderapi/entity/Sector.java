package com.workderapi.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.workderapi.baseEntity.NameDescriptionEntity;

@Entity
@Table (name = "sectors")
public class Sector extends NameDescriptionEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "sector")
	@JsonIgnore
	private List<Company> companys;

	/*---------------------GETTERS AND SETTERS---------------------*/

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Company> getCompanys() {
		return companys;
	}

	public void setCompanys(List<Company> companys) {
		this.companys = companys;
	}
	

}
