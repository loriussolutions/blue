package com.lorius.revenues.blue.entity;

import java.util.GregorianCalendar;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public class AbstractEntity {

	@Id
	//@GeneratedValue
	@Column(name = "id")
	private String id;
	
	@Column(name = "createdOn")
	private GregorianCalendar createdOn;
	
	@Column(name = "updatedOn")
	private GregorianCalendar updatedOn;
	
	@Version
	@Column(name = "version")
	private Integer version;

	public AbstractEntity() {
		id = UUID.randomUUID().toString();
		createdOn = new GregorianCalendar();
		updatedOn = new GregorianCalendar();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public GregorianCalendar getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(GregorianCalendar createdOn) {
		this.createdOn = createdOn;
	}

	public GregorianCalendar getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(GregorianCalendar updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
}
