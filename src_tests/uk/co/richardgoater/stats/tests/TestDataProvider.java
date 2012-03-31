package uk.co.richardgoater.stats.tests;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import uk.co.richardgoater.stats.persistence.DefenseGameData;
import uk.co.richardgoater.stats.persistence.Player;
import uk.co.richardgoater.stats.persistence.ScheduleWeek;
import uk.co.richardgoater.stats.persistence.Season;
import uk.co.richardgoater.stats.persistence.dao.ScheduleDAO;
import uk.co.richardgoater.stats.persistence.dao.StatsDAO;

public class TestDataProvider {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("uk/co/richardgoater/stats/tests/Spring-test.xml");
		createSelectionRecords((ScheduleDAO) context.getBean("SelectionDAO"));
		createStatsRecords((StatsDAO) context.getBean("DefenseStatsDAO"));
	}

	public static void createStatsRecords(StatsDAO dao) {
		Player p = new Player("Thomas Hutton", 28, "CB", false);
		p.setPlayerid(1);
		p.setDefense(true);
		p.setSeasonid(1);
		dao.saveOrReplace(p);
		
		Player p2 = new Player("Mark Foster", 47, "S", false);
		p2.setPlayerid(2);
		p2.setDefense(true);
		p2.setSeasonid(1);
		dao.saveOrReplace(p2);
		
		Player p3 = new Player("Richard Goater", 27, "K", true);
		p3.setPlayerid(3);
		p3.setDefense(true);
		p3.setSeasonid(1);
		dao.saveOrReplace(p3);
		
		DefenseGameData dgd = new DefenseGameData();
		dgd.setWeeknum(3);
		dgd.setPlayerid(1);
		dgd.setTckl(2);
		dgd.setInts(2);
		dgd.setSeasonid(1);
		dao.saveOrReplace(dgd);
		
		DefenseGameData dgd2 = new DefenseGameData();
		dgd2.setWeeknum(3);
		dgd2.setPlayerid(2);
		dgd2.setTckl(2);
		dgd2.setInts(2);
		dgd2.setSeasonid(1);
		dao.saveOrReplace(dgd2);
	}

	public static void createSelectionRecords(ScheduleDAO dao) {
		Season all = new Season();
		all.setYear("All");
		dao.saveSeason(all);
		
		Season s2010 = new Season();
		s2010.setYear("2010");
		s2010.setSeasonid(1);
		dao.saveSeason(s2010);
		
		Season s2011 = new Season();
		s2011.setYear("2011");
		s2011.setSeasonid(2);
		dao.saveSeason(s2011);
		
		ScheduleWeek s2 = new ScheduleWeek();
		s2.setWeeknum(0);		
		s2.setSeasonID(0);
		dao.saveScheduleWeek(s2);
		
		ScheduleWeek s3 = new ScheduleWeek();
		s3.setWeeknum(0);		
		s3.setSeasonID(1);
		dao.saveScheduleWeek(s3);
		
		ScheduleWeek s4 = new ScheduleWeek();
		s4.setWeeknum(0);		
		s4.setSeasonID(2);
		dao.saveScheduleWeek(s4);
		
		ScheduleWeek s = new ScheduleWeek();
		s.setDate(new Date());
		s.setOpponent("Maidstone Pumas");
		s.setWeeknum(3);
		s.setHome(true);
		s.setSeasonID(1);
		dao.saveScheduleWeek(s);
	}

}
