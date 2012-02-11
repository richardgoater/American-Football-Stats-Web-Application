package uk.co.richardgoater.stats.persistence.dao;

import java.util.Date;
import java.util.List;

import uk.co.richardgoater.stats.persistence.DefenseGameData;
import uk.co.richardgoater.stats.persistence.GameData;
import uk.co.richardgoater.stats.persistence.Player;
import uk.co.richardgoater.stats.persistence.ScheduleWeek;

public class DefenseStatsDAOImpl extends StatsDAOImpl {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<GameData> getGameDataForWeek(ScheduleWeek week, String table) {
		System.out.println(table + " " + new Date());
		return hibernateTemplate.find("from DefenseGameData where weeknum = " + week.getWeeknum() 
				+ " and seasonid = " + week.getSeasonID());
	}	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<GameData> getGameDataTotals(int seasonid, String table) {
		System.out.println(table);
		List<Object[]> list = hibernateTemplate.find("select " +
				"dgd.playerid," +
				"sum(dgd.tckl) as tckl," +
				"sum(dgd.solo) as solo," +
				"sum(dgd.assist) as assist," +
				"sum(dgd.sck) as sck," +
				"sum(dgd.sckYds) as sckYds," +
				"sum(dgd.qbHurry) as qbHurry," +
				"sum(dgd.ints) as ints," +
				"sum(dgd.intYds) as intYds," +
				"sum(dgd.bp) as bp," +
				"sum(dgd.ff) as ff," +
				"sum(dgd.fr) as fr," +
				"sum(dgd.frYds) as frYds," +
				"sum(dgd.td) as td," +
				"sum(dgd.safety) as safety," +
				"sum(dgd.bk) as bk" +
				" from DefenseGameData dgd" + appendSeasonClause( " where", seasonid) + " group by dgd.playerid");
		
		return constructGameData(list);
	}

	@Override
	protected GameData constructGameDataObject(Object[] data) {
		DefenseGameData dgd = new DefenseGameData();
		dgd.setPlayerid((Integer) data[0]);
		dgd.setTckl(((Long)data[1]).intValue());
		dgd.setSolo(((Long)data[2]).intValue());
		dgd.setAssist(((Long)data[3]).intValue());
		dgd.setSck((Double) data[4]);
		dgd.setSckYds(((Long)data[5]).intValue());
		dgd.setQbHurry(((Long)data[6]).intValue());
		dgd.setInts(((Long)data[7]).intValue());
		dgd.setIntYds(((Long)data[8]).intValue());
		dgd.setBp(((Long)data[9]).intValue());
		dgd.setFf(((Long)data[10]).intValue());
		dgd.setFr(((Long)data[11]).intValue());
		dgd.setFrYds(((Long)data[12]).intValue());
		dgd.setTd(((Long)data[13]).intValue());
		dgd.setSafety(((Long)data[14]).intValue());
		dgd.setBk(((Long)data[15]).intValue());
		return dgd;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Player> getPlayers(int seasonid, String statsCategory) {
		return hibernateTemplate.find("from Player where isdefense = 1" + appendSeasonClause( " and", seasonid));
	}
	
}
