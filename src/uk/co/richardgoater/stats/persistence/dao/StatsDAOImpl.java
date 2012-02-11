package uk.co.richardgoater.stats.persistence.dao;

import java.util.ArrayList;
import java.util.List;

import uk.co.richardgoater.stats.persistence.GameData;
import uk.co.richardgoater.stats.persistence.Player;

public abstract class StatsDAOImpl extends HibernateDAO implements StatsDAO {	
	
	public void savePlayer(Player p) {
		hibernateTemplate.saveOrUpdate(p);
		
	}
	
	public void saveGameData(GameData gameData) {
		hibernateTemplate.saveOrUpdate(gameData);	
	}
	
	protected List<GameData> constructGameData(List<Object[]> list) {
		List<GameData> dataList = new ArrayList<GameData>();
		for(Object[] data : list) {
			dataList.add(constructGameDataObject(data));
		}	
		return dataList;
	}
	
	abstract protected GameData constructGameDataObject(Object[] data);
	
	protected String appendSeasonClause(String prefix, int seasonid) {
		if(seasonid > 0)
			return prefix + " seasonid = " + seasonid;
		
		return "";
	}
}
