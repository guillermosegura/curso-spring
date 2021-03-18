package mx.com.axity.poc.service.impl;

import mx.com.axity.poc.dao.impl.DataDAOImpl;
import mx.com.axity.poc.service.Service;
import mx.com.axity.poc.to.Data;

public class ServiceImpl implements Service {

	private DataDAOImpl dataDAO;

	@Override
	public void save(Data data) {
		this.dataDAO.insert(data);
	}

	public void setDataDAO(DataDAOImpl dataDao) {
		this.dataDAO = dataDao;
	}

}
