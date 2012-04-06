package uk.co.richardgoater.stats.persistence.dao;

import java.util.List;

import uk.co.richardgoater.common.persistence.HibernateDAO;
import uk.co.richardgoater.stats.persistence.ScheduleWeek;
import uk.co.richardgoater.stats.persistence.Season;

public class ScheduleDAOImpl extends HibernateDAO implements ScheduleDAO {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getScheduleWeeks(int seasonID) {
		return hibernateTemplate.find(
				"from ScheduleWeek where seasonid = " + seasonID);
	}
	
	@Override
	public void saveScheduleWeek(ScheduleWeek s) {
		hibernateTemplate.saveOrUpdate(s);	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getSeasons() {
		return hibernateTemplate.find("from Season");
	}

	@Override
	public void saveSeason(Season s) {
		hibernateTemplate.saveOrUpdate(s);
		saveScheduleWeek(new ScheduleWeek(0, "All", null, false, s.getSeasonid()));
	}

	@Override
	public void removeSeasonAndData(int seasonid) {
		String whereClause = "";
		
		if(seasonid > 0)
			whereClause = "where seasonid = " + seasonid;
	
		String[] tables = {"Season", "ScheduleWeek", "Player", "GameData"};
		bulkRemove(tables, whereClause);
		
		if(seasonid == 0)
			saveSeason(new Season(0, "All"));
	}

	@Override
	public void removeWeekAndData(int weeknum, int seasonid) {
		String whereClause = "where seasonid = " + seasonid;
		
		if(weeknum > 0)
			whereClause += " and weeknum = " + weeknum;
		
		String[] tables = {"ScheduleWeek", "Player", "GameData"};
		bulkRemove(tables, whereClause);
		
		if(weeknum == 0)
			saveScheduleWeek(new ScheduleWeek(0, "All", null, false, seasonid));
	}
}
