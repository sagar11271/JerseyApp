package com.ragas.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Model {
	private int id;
	private String name;
	private long contact;
	
	public Model() {}
	
	public Model(int id, String name, long contact) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
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
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "Model [id=" + id + ", name=" + name + ", contact=" + contact + "]";
	}
	

}
