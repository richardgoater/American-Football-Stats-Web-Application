package uk.co.richardgoater.stats.persistence.dao;

import java.util.List;

import uk.co.richardgoater.stats.persistence.GameData;
import uk.co.richardgoater.stats.persistence.Player;
import uk.co.richardgoater.stats.persistence.RushingGameData;
import uk.co.richardgoater.stats.persistence.ScheduleWeek;

public class RushingStatsDAOImpl extends StatsDAOImpl {

	@Override
	protected GameData constructGameDataObject(Object[] data) {
		RushingGameData rgd = new RushingGameData();
		rgd.setPlayerid((Integer)data[0]);
		rgd.setAtt(((Long)data[1]).intValue());
		rgd.setYds(((Long)data[2]).intValue());
		rgd.setLongest(((Long)data[3]).intValue());
		rgd.setTd(((Long)data[4]).intValue());
		return rgd;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<GameData> getGameDataForWeek(ScheduleWeek week, String table) {
		System.out.println(table);
		return hibernateTemplate.find("from RushingGameData where weeknum = " + week.getWeeknum() + " and seasonid = " + week.getSeasonID());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<GameData> getGameDataTotals(int seasonid, String table) {
		System.out.println(table);
		return hibernateTemplate.find("select rgd.playerid, " +
				"sum(rgd.att) as att," +
				"sum(rgd.yds) as yds," +
				"max(rgd.longest) as longest," +
				"sum(rgd.td) as td" +
				" from RushingGameData rgd" + appendSeasonClause( " where", seasonid) + " group by rgd.playerid");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Player> getPlayers(int seasonid, String table) {
		return hibernateTemplate.find("from Player where isrushing = 1" + appendSeasonClause(" and", seasonid));		
	}

}
