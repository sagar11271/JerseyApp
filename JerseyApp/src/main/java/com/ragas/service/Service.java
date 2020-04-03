package com.ragas.service;

import com.ragas.model.Model;

public interface Service {

	public String getData();
	public String getDataById(int id);
	public String delData(int id) ;
	public String addData(Model m);
	public String updateData(Model m);
	
}
