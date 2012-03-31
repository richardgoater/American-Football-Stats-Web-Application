package uk.co.richardgoater.stats.persistence.dao.gamedata;

import java.util.List;

import uk.co.richardgoater.stats.persistence.GameData;
import uk.co.richardgoater.stats.persistence.Player;
import uk.co.richardgoater.stats.persistence.ScheduleWeek;

public class PassingGameDataDAO extends AbstractGameDataDAO implements GameDataDAO {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<GameData> getGameDataForWeek(ScheduleWeek week) {
		return hibernateTemplate.find("from PassingGameData where weeknum = " + week.getWeeknum() + " and seasonid = " + week.getSeasonID());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<GameData> getGameDataTotals(int seasonid) {
		return hibernateTemplate.find("select " +
				"new uk.co.richardgoater.stats.persistence.PassingGameData (" +
				"pgd.playerid," + 
				"sum(pgd.att)," + 
				"sum(pgd.comp)," + 
				"sum(pgd.yds)," + 
				"max(pgd.longest)," +
				"sum(pgd.td)," + 
				"sum(pgd.ints)," + 
				"sum(pgd.sck)," +
				"sum(pgd.sackYds))" +			 				
				" from PassingGameData pgd" + appendSeasonClause( " where", seasonid) + " group by pgd.playerid");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Player> getPlayers(int seasonid) {
		return hibernateTemplate.find("from Player where ispassing = 1" + appendSeasonClause( " and", seasonid));
	}

}
