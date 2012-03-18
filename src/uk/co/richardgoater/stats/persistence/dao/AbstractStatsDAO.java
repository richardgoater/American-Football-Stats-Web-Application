package uk.co.richardgoater.stats.persistence.dao;

public abstract class AbstractStatsDAO extends HibernateDAO implements StatsDAO {	
	
	protected String appendSeasonClause(String prefix, int seasonid) {
		if(seasonid > 0)
			return prefix + " seasonid = " + seasonid;
		
		return "";
	}

	@Override
	public void saveOrReplace(Object mappedObject) {
		hibernateTemplate.saveOrUpdate(mappedObject);		
	}
	
	public int getPlayeridForName(String playerName) {
		// TODO Auto-generated method stub
		return 0;
	}
}
