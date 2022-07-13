package mx.com.axity.poc.service.impl;

import mx.com.axity.poc.dao.DataDAO;
import mx.com.axity.poc.service.Service;
import mx.com.axity.poc.to.Data;

public class ServiceImpl implements Service {

	private DataDAO dataDAO;

	@Override
	public void save(Data data) {
		this.dataDAO.insert(data);
	}

	public void setDataDAO(DataDAO dataDao) {
		this.dataDAO = dataDao;

	}

}
