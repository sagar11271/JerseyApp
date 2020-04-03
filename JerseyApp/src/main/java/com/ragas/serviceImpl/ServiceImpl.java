package com.ragas.serviceImpl;

import java.util.concurrent.CopyOnWriteArrayList;
import org.codehaus.jackson.map.ObjectMapper;
import com.ragas.model.Model;
import com.ragas.service.Service;

public class ServiceImpl implements Service{
	CopyOnWriteArrayList<Model> datas;
	// if we use arraylist then possibility of occurrence of concurrent modification exception so use CopyOnWriteArrayList
	Model data1,data2,data3,data4;
	String msg = null;
	ObjectMapper obj;
	
	public ServiceImpl() {

		datas = new CopyOnWriteArrayList<Model>();
		data1 = new Model(101, "Sagar Bhardwaj", 987654321);
		data2 = new Model(102, "Deepak Thakur", 123456789);
		data3 = new Model(103, "Akshay Jaiswal", 999999999);
		datas.add(data1);
		datas.add(data2);
		datas.add(data3);
	}
	
	public String getData() {
		obj = new ObjectMapper(); //convert java object to json string
		try {
			msg = obj.writeValueAsString(datas);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return msg;
	}

	public String getDataById(int id) {
		int i = 0;
		while (i < datas.size()) {
			if (datas.get(i).getId() == id) {
				data4 = datas.get(i);
				break;
			}
			i++;
		}
		
		obj = new ObjectMapper();
		try {
			msg = obj.writeValueAsString(data4);
			System.out.println(msg);

		} catch (Exception e) {			e.printStackTrace();		}
		
		return msg;
	}

	public String delData(int id) {
		
		for (Model data : datas) {
			if (data.getId() == id) {
				System.out.println("inside if");
				datas.remove(data);
				msg = "{ \"status\":true }";
				break;
			}
			else
				msg = "{ \"status\":false }";
		}
		return msg;
	}

	public String addData(Model m) {
		int flag=0;
		for(Model data: datas) {
			if(m.getId() == data.getId()) {
				msg = "{ \"status\":false }";	// data with same id already present	
				flag=1;
				break;
			}
		}
		
		if(flag==0) {
			Model data4 =new Model();
			data4.setContact(m.getContact());
			data4.setId(m.getId());
			data4.setName(m.getName());
			datas.add(data4);
			msg = "{ \"status\":true }";
			System.out.println(data4);
		}
		
		return msg;
	}

	public String updateData(Model m) {
		int flag=0;
		 for(Model data: datas) {
			 if(m.getId() == data.getId()) {
				datas.set(flag, m);
				 
			 }
			 flag++;
		 }
		 if (flag>0) msg = "{ \"status\":true }";
		 else msg = "{ \"status\":false }";
		return msg;
	}



}
