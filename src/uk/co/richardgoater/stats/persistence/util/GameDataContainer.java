package uk.co.richardgoater.stats.persistence.util;

import java.util.List;
import java.util.Map;

import uk.co.richardgoater.stats.persistence.GameData;
import uk.co.richardgoater.stats.persistence.Player;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.ItemSorter;

@SuppressWarnings({ "serial", "rawtypes" })
public class GameDataContainer extends BeanItemContainer {

	ItemSorter statsItemSorter = new StatsItemSorter();
	
	@SuppressWarnings({ "unchecked" })
	public GameDataContainer(Class type) throws IllegalArgumentException {
		super(type); 

		addNestedContainerProperty("player.displayName");
//		addNestedContainerProperty("player.displayNumber");
//		addNestedContainerProperty("player.position");
	}

	@SuppressWarnings("unchecked")
	public void addGameDataBeans(List<GameData> beans,
			Map<Integer, Player> players) {
		
		if(beans != null) {
			for (GameData bean : beans) {
				Player p = players.remove(bean.getPlayerid());
				if(p != null) {
					bean.setPlayer(p);
					addBean(bean);
				}
			}
			addZeroRows(players);
		}
	}

	@SuppressWarnings("unchecked")
	private void addZeroRows(Map<Integer, Player> players) {

		for (Player p : players.values()) {

			GameData bean;
			try {
				bean = (GameData) getBeanType().newInstance();
				bean.setPlayer(p);
				addBean(bean);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public ItemSorter getItemSorter() {
		return statsItemSorter;
	}

}
