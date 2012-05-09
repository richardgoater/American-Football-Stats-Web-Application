package uk.co.richardgoater.stats.persistence.dao.gamedata;

import java.util.List;

import uk.co.richardgoater.stats.persistence.GameData;
import uk.co.richardgoater.stats.persistence.Player;
import uk.co.richardgoater.stats.persistence.ScheduleWeek;

public class ReceivingGameDataDAO extends AbstractGameDataDAO implements GameDataDAO {
	
	@Override
	protected String getTableName() {
		return "ReceivingGameData";
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<GameData> getGameDataForWeek(ScheduleWeek week) {
		return hibernateTemplate.find("from ReceivingGameData where weeknum = " + week.getWeeknum() + " and seasonid = " + week.getSeasonID());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<GameData> getGameDataTotals(int seasonid) {
		return hibernateTemplate.find("select " +
				"new uk.co.richardgoater.stats.persistence.ReceivingGameData (" +
				"rgd.playerid," +
				"sum(rgd.rec)," +
				"sum(rgd.yds)," +
				"max(rgd.longest)," +
				"sum(rgd.td))" +
				" from ReceivingGameData rgd" + appendSeasonClause(" where", seasonid) + " group by rgd.playerid");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Player> getPlayers(int seasonid) {
		return hibernateTemplate.find("from Player where isreceiving = 1" + appendSeasonClause(" and", seasonid)
				+ " order by number asc");
	}

}
