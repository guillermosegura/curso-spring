package mx.com.axity.poc.service.impl;

import mx.com.axity.poc.dao.DataDAO;
import mx.com.axity.poc.service.Service;
import mx.com.axity.poc.to.Data;

/**
 * Clase que implementa la interface {@link mx.com.axity.poc.service.Service}
 * 
 * @author guillermo.segura@axity.com
 */
public class ServiceImpl implements Service {

	private DataDAO dataDAO;

  /**
   * {@inheritDoc}
   */
	@Override
	public void save(Data data) {
		this.dataDAO.insert(data);
	}

  /**
   * Setter de dao
   * 
   * @param dataDao
   */
	public void setDataDAO(DataDAO dataDao) {
		this.dataDAO = dataDao;

	}

}
