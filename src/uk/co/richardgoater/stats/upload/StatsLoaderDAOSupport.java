package uk.co.richardgoater.stats.upload;

import java.util.List;

import uk.co.richardgoater.stats.persistence.dao.StatsDAO;


public class StatsLoaderDAOSupport  {
	
	private List<StatsDAO> DAOList;

	public List<StatsDAO> getDAOList() {
		return DAOList;
	}

	public void setDAOList(List<StatsDAO> daoList) {
		DAOList = daoList;
	}

}
