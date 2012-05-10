package uk.co.richardgoater.stats.persistence.dao.gamedata;

import java.util.List;

import uk.co.richardgoater.stats.persistence.GameData;
import uk.co.richardgoater.stats.persistence.ScheduleWeek;

public class RushingGameDataDAO extends AbstractGameDataDAO implements GameDataDAO {
	
	@Override
	protected String getTableName() {
		return "RushingGameData";
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<GameData> getGameDataForWeek(ScheduleWeek week) {
		return hibernateTemplate.find("from RushingGameData where weeknum = " + week.getWeeknum() + " and seasonid = " + week.getSeasonID());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<GameData> getGameDataTotals(int seasonid) {
		return hibernateTemplate.find("select " +
				"new uk.co.richardgoater.stats.persistence.RushingGameData (" +
				"rgd.playerid, " +
				"sum(rgd.att)," +
				"sum(rgd.yds)," +
				"max(rgd.longest)," +
				"sum(rgd.td))" +
				" from RushingGameData rgd" + appendSeasonClause( " where", seasonid) + " group by rgd.playerid");
	}
	
	@Override
	protected String getPlayerTypeColumn() {
		return "isrushing";
	}

}
