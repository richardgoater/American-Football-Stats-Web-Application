package uk.co.richardgoater.stats.upload.excel.mapping;

import uk.co.richardgoater.stats.persistence.dao.AbstractStatsDAO;
import uk.co.richardgoater.stats.persistence.dao.StatsDAO;

public abstract class RowMapperDAOSupport {

	protected AbstractStatsDAO dao;
	
	public void setDAO(AbstractStatsDAO dao) {
		this.dao = dao;
	}
	
	public StatsDAO getDAO() {
		return dao;
	}
	
}
