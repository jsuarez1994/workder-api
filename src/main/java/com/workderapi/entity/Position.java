package com.workderapi.entity;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.workderapi.baseEntity.NameDescriptionEntity;

@Entity
@Table(name="positions")
public class Position extends NameDescriptionEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "position")
	@JsonIgnore
	private List<User> users;

	
	/*---------------------GETTERS AND SETTERS---------------------*/
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
