package com.workderapi.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.workderapi.baseEntity.DateEntity;

@Entity
@Table(name = "orders")
public class Order extends DateEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotNull
	@NotEmpty
	private String title;
	
	@NotNull
	@NotEmpty
	private String description;
	
	@Column(name = "date_Init")
	@Temporal(TemporalType.DATE)
	private Date dateInit;
	
	@Column(name = "date_finish")
	@Temporal(TemporalType.DATE)
	private Date dateFinish;
	
	/**
	 * FYI (Date complete/incomplete in database):
	 * Complete : 	1
	 * Incomplete: 	0
	 * */
	@Column(name = "complete")
	private Boolean complete;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user")
	@JsonIgnore
	private User user;

	/*---------------------GETTERS AND SETTERS---------------------*/

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateInit() {
		return dateInit;
	}

	public void setDateInit(Date dateInit) {
		this.dateInit = dateInit;
	}

	public Date getDateFinish() {
		return dateFinish;
	}

	public void setDateFinish(Date dateFinish) {
		this.dateFinish = dateFinish;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getComplete() {
		return complete;
	}

	public void setComplete(Boolean complete) {
		this.complete = complete;
	}
	
}
