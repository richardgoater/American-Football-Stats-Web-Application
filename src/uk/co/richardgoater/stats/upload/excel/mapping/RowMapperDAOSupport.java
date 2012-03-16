package uk.co.richardgoater.stats.upload.excel.mapping;

import uk.co.richardgoater.stats.persistence.dao.StatsDAO;

public abstract class RowMapperDAOSupport {

	protected StatsDAO dao;
	
	public void setDAO(StatsDAO dao) {
		this.dao = dao;
	}
	
	public StatsDAO getDAO() {
		return dao;
	}
	
}
