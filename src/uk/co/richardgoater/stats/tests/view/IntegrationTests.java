package uk.co.richardgoater.stats.tests.view;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import uk.co.richardgoater.stats.persistence.DefenseGameData;
import uk.co.richardgoater.stats.persistence.GameData;
import uk.co.richardgoater.stats.persistence.Player;
import uk.co.richardgoater.stats.persistence.dao.ScheduleDAO;
import uk.co.richardgoater.stats.persistence.dao.StatsDAO;
import uk.co.richardgoater.stats.tests.TestDataProvider;
import uk.co.richardgoater.stats.ui.DefenseTable;
import uk.co.richardgoater.stats.ui.SeasonSelector;
import uk.co.richardgoater.stats.ui.StatsTable;
import uk.co.richardgoater.stats.ui.WeekSelector;

public class IntegrationTests {
	
	ApplicationContext context;
	ScheduleDAO selectionDao; 
	StatsDAO statsDao;
	List<StatsTable> tables;
	Player p;
	Player p2;
	SeasonSelector seasonSelector;
	WeekSelector weekSelector;
	
	public IntegrationTests() {
		context = new ClassPathXmlApplicationContext("uk/co/richardgoater/stats/tests/Spring-test.xml");
		statsDao = (StatsDAO) context.getBean("DefenseStatsDAO");
		selectionDao = (ScheduleDAO) context.getBean("SelectionDAO");
	}
	
	@Before
	public void setUp() {
		
		TestDataProvider.createSelectionRecords(selectionDao);
		TestDataProvider.createStatsRecords(statsDao);		
		
		tables = new ArrayList<StatsTable>();
		tables.add(new DefenseTable(statsDao));
		
		weekSelector = new WeekSelector(tables, selectionDao);
		seasonSelector  = new SeasonSelector(tables, selectionDao, weekSelector);
	}
	
	@Test
	public void testGetPlayers() {
		List<Player> players = statsDao.getPlayers(1);
		assertEquals(3, players.size());
	}
	
	@Test
	public void testGetDefenseTotals() {
		List<GameData> totals = statsDao.getGameDataTotals(1);
		assertNotNull(totals);
		assertEquals(2, totals.size());
		DefenseGameData dgd = (DefenseGameData) totals.get(0); 
		assertEquals(2, dgd.getTckl());
	}
	
	@Test
	public void multiSelectTest() {
		seasonSelector.setValue(selectionDao.getSeasons().get(0));
		weekSelector.setValue(selectionDao.getScheduleWeeks(0).get(0));
		assertEquals(3, tables.get(0).size());
		
		seasonSelector.setValue(selectionDao.getSeasons().get(1));
		weekSelector.setValue(selectionDao.getScheduleWeeks(1).get(0));
		
		seasonSelector.setValue(selectionDao.getSeasons().get(0));
		weekSelector.setValue(selectionDao.getScheduleWeeks(0).get(0));
		assertEquals(3, tables.get(0).size());
	}
	
}
