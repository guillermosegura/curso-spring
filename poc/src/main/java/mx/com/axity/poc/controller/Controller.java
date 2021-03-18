package mx.com.axity.poc.controller;

import mx.com.axity.poc.dao.impl.DataDAOImpl;
import mx.com.axity.poc.service.impl.ServiceImpl;
import mx.com.axity.poc.to.Data;

public class Controller {

	private ServiceImpl service;

	public Controller() {
		service = new ServiceImpl();
		DataDAOImpl dataDAO = new DataDAOImpl();
		service.setDataDAO(dataDAO);
	}

	public void save(Data data) {
		service.save(data);
	}

}
