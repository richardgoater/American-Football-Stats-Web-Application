package uk.co.richardgoater.stats.persistence.dao;

import uk.co.richardgoater.stats.persistence.GameData;
import uk.co.richardgoater.stats.persistence.Player;

public abstract class StatsDAOImpl extends HibernateDAO implements StatsDAO {	
	
	public void savePlayer(Player p) {
		hibernateTemplate.saveOrUpdate(p);	
	}
	
	public void saveGameData(GameData gameData) {
		hibernateTemplate.saveOrUpdate(gameData);	
	}
	
	protected String appendSeasonClause(String prefix, int seasonid) {
		if(seasonid > 0)
			return prefix + " seasonid = " + seasonid;
		
		return "";
	}
	
	protected void saveOrReplacePlayer(Player p) {
		
	}
}
