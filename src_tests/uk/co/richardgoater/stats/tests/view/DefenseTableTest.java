package uk.co.richardgoater.stats.tests.view;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import uk.co.richardgoater.stats.persistence.DefenseGameData;
import uk.co.richardgoater.stats.persistence.Player;
import uk.co.richardgoater.stats.persistence.dao.ScheduleDAO;
import uk.co.richardgoater.stats.persistence.dao.gamedata.GameDataDAO;
import uk.co.richardgoater.stats.tests.fake.FakeScheduleDAO;
import uk.co.richardgoater.stats.tests.fake.FakeStatsDAO;
import uk.co.richardgoater.stats.ui.SeasonSelector;
import uk.co.richardgoater.stats.ui.WeekSelector;
import uk.co.richardgoater.stats.ui.table.DefenseTable;
import uk.co.richardgoater.stats.ui.table.StatsTable;

import com.vaadin.data.Item;

public class DefenseTableTest {
	
	GameDataDAO dao;
	ScheduleDAO dao2;
	DefenseGameData dgd;
	DefenseTable dt;
	WeekSelector ws;
	SeasonSelector ss;
	Player p;
	
	@Before
	public void setUp() {
		dao = new FakeStatsDAO();
		dao2 = new FakeScheduleDAO();

		dgd = new DefenseGameData();
		dgd.setGamedataid(1);
		dgd.setWeeknum(1);
		dgd.setPlayerid(1);
		dgd.setTckl(5);
		dgd.setInts(2);
		
		p = new Player(1, "Richard Goater", 27, "K", "false");
		p.setPlayerid(1);
		p.setDefense(true);
		
		dgd.setPlayer(p);
		
		dt = new DefenseTable(dao);
		ArrayList<StatsTable> tableList = new ArrayList<StatsTable>();
		tableList.add(dt);
		ws = new WeekSelector(tableList, dao2);
		ss = new SeasonSelector(tableList, dao2, ws);
		
		ss.setValue(dao2.getSeasons().get(0)); // action
		ws.setValue(dao2.getScheduleWeeks(1).get(1)); // action
	}
	
	@Test
	public void defenseTableTest() {
		assertEquals(2, dt.getContainerDataSource().size());
		Item i = dt.getItem(dgd);
		assertEquals(5, i.getItemProperty("tckl").getValue());
	}
	
	@Test
	public void columnHeaderTest() {
		assertEquals("INT", dt.getColumnHeader("ints"));
		assertEquals("#", dt.getColumnHeader("player.displayNumber"));		
		assertEquals("TCKL", dt.getColumnHeader("tckl"));
	}

}
