package uk.co.richardgoater.stats.persistence.dao;

import java.util.List;

import uk.co.richardgoater.common.persistence.HibernateDAO;

public abstract class AbstractStatsDAO extends HibernateDAO {	
	
	protected String appendSeasonClause(String prefix, int seasonid) {
		if(seasonid > 0)
			return prefix + " seasonid = " + seasonid;
		
		return "";
	}

	public int getPlayeridForName(String playerName, int seasonid) throws Exception {
		@SuppressWarnings("unchecked")
		List<Object> result = hibernateTemplate.find(
				"select playerid from Player " +
				"where name = '" + playerName + "'" +
				"and seasonid = " + seasonid);
		
		if(result.size() > 0)
			return (Integer) result.get(0);
		else throw new Exception("No player found for name '" + playerName + "'");
	}
	
	public void saveOrReplace(Object mappedObject) {
				
		@SuppressWarnings("unchecked")
		List<Object> existingRecords = hibernateTemplate.find(
				getExistingRecordsQuery(mappedObject));
		
		if(existingRecords.size() > 0) {
			hibernateTemplate.delete(existingRecords.get(0));
		}
		
		hibernateTemplate.saveOrUpdate(mappedObject);
	}
	
	public abstract String getExistingRecordsQuery(Object mappedObject);
}
