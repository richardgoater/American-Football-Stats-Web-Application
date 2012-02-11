package uk.co.richardgoater.stats.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import uk.co.richardgoater.stats.persistence.DefenseGameData;
import uk.co.richardgoater.stats.persistence.Player;
import uk.co.richardgoater.stats.persistence.dao.StatsDAO;
import uk.co.richardgoater.stats.tests.mock.StatsDAOMockImpl;

import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Table;

public class PreliminaryTests {

	BeanItemContainer<DefenseGameData> container;
	StatsDAO dao;
	DefenseGameData dgd;
	Player p;
	
	@Before
	public void setUp() {
		dao = new StatsDAOMockImpl();

		container = new BeanItemContainer<DefenseGameData>(
				DefenseGameData.class);

		dgd = new DefenseGameData();
		dgd.setGamedataid(1);
		dgd.setWeeknum(1);
		dgd.setPlayerid(1);
		dgd.setTckl(5);
		dgd.setInts(2);
		
		p = new Player("Richard Goater", 27, "K", false);
		p.setPlayerid(1);
		p.setDefense(true);
		
		dgd.setPlayer(p);
		
		container.addNestedContainerProperty("player.name");
		container.addNestedContainerProperty("player.number");
		container.addNestedContainerProperty("player.position");
		
		container.addBean(dgd);	
	}

	@Test
	public void beanItemContainerTest() {

		Table t = new Table("Test", container);
		t.setVisibleColumns(dgd.getVisibleColumns());

		String[] headers = t.getColumnHeaders();
		System.out.println("Length: " + headers.length);
		for (String h : headers)
			System.out.println(h);

		Assert.assertEquals(14, headers.length);
	}
	
	@Test
	public void propertiesTest() {
		Table t = new Table("Test", container);
		t.setVisibleColumns(dgd.getVisibleColumns());
		
		Item i = t.getItem(dgd);
		Assert.assertEquals(5, i.getItemProperty("tckl").getValue());
		Assert.assertEquals(5.0, i.getItemProperty("ydsPerInt").getValue());
	}
}
