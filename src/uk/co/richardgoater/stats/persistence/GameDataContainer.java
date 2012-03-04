package uk.co.richardgoater.stats.persistence;

import java.util.List;
import java.util.Map;

import com.vaadin.data.util.BeanItemContainer;

@SuppressWarnings( { "serial" })
public class GameDataContainer extends BeanItemContainer {

	public GameDataContainer(Class type) throws IllegalArgumentException {
		super(type);

		addNestedContainerProperty("player.name");
		addNestedContainerProperty("player.number");
		addNestedContainerProperty("player.position");
	}

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
	
	

}
