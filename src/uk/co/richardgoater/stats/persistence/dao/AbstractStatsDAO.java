package uk.co.richardgoater.stats.persistence.dao;

import java.util.List;

public abstract class AbstractStatsDAO extends HibernateDAO {	
	
	protected String appendSeasonClause(String prefix, int seasonid) {
		if(seasonid > 0)
			return prefix + " seasonid = " + seasonid;
		
		return "";
	}

	public int getPlayeridForName(String playerName) {
		@SuppressWarnings("unchecked")
		List<Object> result = hibernateTemplate.find(
				"select playerid from Player " +
				"where name = '" + playerName + "'");
		
		if(result.size() > 0)
			return (Integer) result.get(0);
		else return 0;
	}
}
