package uk.co.richardgoater.stats.persistence.dao;

import java.util.List;

import uk.co.richardgoater.stats.persistence.GameData;
import uk.co.richardgoater.stats.persistence.PassingGameData;
import uk.co.richardgoater.stats.persistence.Player;
import uk.co.richardgoater.stats.persistence.ScheduleWeek;

public class PassingStatsDAOImpl extends StatsDAOImpl {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<GameData> getGameDataForWeek(ScheduleWeek week, String table) {
		System.out.println(table);
		return hibernateTemplate.find("from PassingGameData where weeknum = " + week.getWeeknum() + " and seasonid = " + week.getSeasonID());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<GameData> getGameDataTotals(int seasonid, String table) {
		System.out.println(table);
		List<Object[]> list = hibernateTemplate.find("select pgd.playerid," + 
				"sum(pgd.att) as att," + 
				"sum(pgd.comp) as comp," + 
				"sum(pgd.yds) as yds," + 
				"max(pgd.longest) as longest," +
				"sum(pgd.td) as td," + 
				"sum(pgd.ints) as ints," + 
				"sum(pgd.sck) as sck," +
				"sum(pgd.sackYds) as sackYds" +			 				
				" from PassingGameData pgd" + appendSeasonClause( " where", seasonid) + " group by pgd.playerid");
		
		return constructGameData(list);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Player> getPlayers(int seasonid, String table) {
		System.out.println(table);
		return hibernateTemplate.find("from Player where ispassing = 1" + appendSeasonClause( " and", seasonid));
	}
	
	@Override
	protected GameData constructGameDataObject(Object[] data) {
		PassingGameData pgd = new PassingGameData();
		pgd.setPlayerid((Integer)data[0]);
		pgd.setAtt(((Long)data[1]).intValue());
		pgd.setComp(((Long)data[2]).intValue());
		pgd.setYds(((Long)data[3]).intValue());
		pgd.setLongest((Integer)data[4]);
		pgd.setTd(((Long)data[5]).intValue());
		pgd.setInts(((Long)data[6]).intValue());
		pgd.setSck(((Long)data[7]).intValue());
		pgd.setSackYds(((Long)data[8]).intValue());
		return pgd;
	}

}
