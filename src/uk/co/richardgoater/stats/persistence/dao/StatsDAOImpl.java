package uk.co.richardgoater.stats.persistence.dao;

import java.util.List;

import uk.co.richardgoater.stats.persistence.GameData;
import uk.co.richardgoater.stats.persistence.Player;

public abstract class StatsDAOImpl extends HibernateDAO implements StatsDAO {	
	
	protected String appendSeasonClause(String prefix, int seasonid) {
		if(seasonid > 0)
			return prefix + " seasonid = " + seasonid;
		
		return "";
	}

	@Override
	public void saveOrReplace(Object mappedObject) {
		
		if(mappedObject instanceof GameData)
			saveOrReplaceGameData((GameData)mappedObject);
		else if (mappedObject instanceof Player)
			saveOrReplacePlayer((Player)mappedObject);
		else
			hibernateTemplate.saveOrUpdate(mappedObject);		
	}
	
	protected void saveOrReplaceGameData(GameData mappedObject) {
		// TODO Auto-generated method stub
		
	}
	
	protected void saveOrReplacePlayer(Player mappedObject) {
		// TODO Auto-generated method stub
		
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
