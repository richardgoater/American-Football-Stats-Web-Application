package uk.co.richardgoater.stats.tests.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import uk.co.richardgoater.stats.persistence.DefenseGameData;
import uk.co.richardgoater.stats.persistence.Player;
import uk.co.richardgoater.stats.persistence.dao.gamedata.GameDataDAO;
import uk.co.richardgoater.stats.tests.fake.FakeStatsDAO;

import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Table;

public class PreliminaryTests {

	BeanItemContainer<DefenseGameData> container;
	GameDataDAO dao;
	DefenseGameData dgd;
	Player p;
	
	int tckl = 5;
	int ints = 2;
	int numberOfColumnHeaders = 18;
	
	@Before
	public void setUp() {
		dao = new FakeStatsDAO();

		container = new BeanItemContainer<DefenseGameData>(
				DefenseGameData.class);

		dgd = new DefenseGameData();
		dgd.setGamedataid(1);
		dgd.setWeeknum(1);
		dgd.setPlayerid(1);
		dgd.setTckl(tckl);
		dgd.setInts(ints);
		
		p = new Player("Richard Goater", 27, "K", false);
		p.setPlayerid(1);
		p.setDefense(true);
		
		dgd.setPlayer(p);
		
		container.addNestedContainerProperty("player.displayName");
		container.addNestedContainerProperty("player.number");
		container.addNestedContainerProperty("player.position");
		
		container.addBean(dgd);	
	}

	@Test
	public void beanItemContainerTest() {

		Table t = new Table("Test", container);
		t.setVisibleColumns(dgd.getVisibleColumns());

		String[] headers = t.getColumnHeaders();
		Assert.assertEquals(numberOfColumnHeaders, headers.length);
	}
	
	@Test
	public void propertiesTest() {
		Table t = new Table("Test", container);
		t.setVisibleColumns(dgd.getVisibleColumns());
		
		Item i = t.getItem(dgd);
		Assert.assertEquals(tckl, i.getItemProperty("tckl").getValue());
		Assert.assertEquals(ints, i.getItemProperty("ints").getValue());
	}
}
