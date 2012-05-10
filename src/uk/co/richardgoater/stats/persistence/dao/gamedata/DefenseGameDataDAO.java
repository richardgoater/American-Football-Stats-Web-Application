package uk.co.richardgoater.stats.persistence.dao.gamedata;

import java.util.List;

import uk.co.richardgoater.stats.persistence.GameData;
import uk.co.richardgoater.stats.persistence.ScheduleWeek;

public class DefenseGameDataDAO extends AbstractGameDataDAO implements GameDataDAO {
	
	@Override
	protected String getTableName() {
		return "DefenseGameData";
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<GameData> getGameDataForWeek(ScheduleWeek week) {
		return hibernateTemplate.find("from DefenseGameData where weeknum = " + week.getWeeknum() 
				+ " and seasonid = " + week.getSeasonID());
	}	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<GameData> getGameDataTotals(int seasonid) {
		return hibernateTemplate.find("select new " +
				"uk.co.richardgoater.stats.persistence.DefenseGameData (" +
				"dgd.playerid," +
				"sum(dgd.tckl)," +
				"sum(dgd.solo)," +
				"sum(dgd.assist)," +
				"sum(dgd.sck)," +
				"sum(dgd.sckYds)," +
				"sum(dgd.qbHurry)," +
				"sum(dgd.ints)," +
				"sum(dgd.intYds)," +
				"sum(dgd.bp)," +
				"sum(dgd.ff)," +
				"sum(dgd.fr)," +
				"sum(dgd.frYds)," +
				"sum(dgd.td)," +
				"sum(dgd.safety)," +
				"sum(dgd.bk))" +
				" from DefenseGameData dgd" + appendSeasonClause( " where", seasonid) + " group by dgd.playerid");
	}
	
	@Override
	protected String getPlayerTypeColumn() {
		return "isdefense";
	}
	
}
