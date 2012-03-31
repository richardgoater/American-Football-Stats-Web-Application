package uk.co.richardgoater.stats.tests.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import uk.co.richardgoater.stats.persistence.Season;
import uk.co.richardgoater.stats.persistence.dao.ScheduleDAO;
import uk.co.richardgoater.stats.persistence.dao.StatsDAO;
import uk.co.richardgoater.stats.tests.fake.FakeScheduleDAO;
import uk.co.richardgoater.stats.tests.fake.FakeStatsDAO;
import uk.co.richardgoater.stats.ui.DefenseTable;
import uk.co.richardgoater.stats.ui.SeasonSelector;
import uk.co.richardgoater.stats.ui.StatsTable;
import uk.co.richardgoater.stats.ui.WeekSelector;
import static org.junit.Assert.*;

public class SeasonSelectorTest {

	ScheduleDAO selectionDao = new FakeScheduleDAO();
	StatsDAO statsDao = new FakeStatsDAO();
	List<StatsTable> tables;
	SeasonSelector seasonSelector;
	WeekSelector weekSelector;
	
	@Before
	public void setUp() {
		tables = new ArrayList<StatsTable>();
		tables.add(new DefenseTable(statsDao));
		
		weekSelector = new WeekSelector(tables, selectionDao);
		seasonSelector  = new SeasonSelector(tables, selectionDao, weekSelector);		
	}
	
	@Test
	public void setupTest() {
		assertNotNull(seasonSelector);
		assertEquals(2, seasonSelector.getContainerDataSource().size());
	}
	
	@Test
	public void selectTest() {
		Season s = (Season) selectionDao.getSeasons().get(0);
		seasonSelector.setValue(s);
		assertEquals(2, weekSelector.getContainerDataSource().size());
	}
	
	@Test
	public void multiSelectTest() {
		seasonSelector.setValue(selectionDao.getSeasons().get(0));
		weekSelector.setValue(selectionDao.getScheduleWeeks(1).get(0));
		seasonSelector.setValue(selectionDao.getSeasons().get(1));
		seasonSelector.setValue(selectionDao.getSeasons().get(0));
		weekSelector.setValue(selectionDao.getScheduleWeeks(1).get(0));
	}
}
