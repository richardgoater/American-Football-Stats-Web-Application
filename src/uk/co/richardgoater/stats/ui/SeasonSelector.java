package uk.co.richardgoater.stats.ui;

import java.util.List;

import uk.co.richardgoater.stats.persistence.Season;
import uk.co.richardgoater.stats.persistence.dao.ScheduleDAO;
import uk.co.richardgoater.stats.ui.table.StatsTable;

public class SeasonSelector extends AbstractSelector {

	private static final long serialVersionUID = -5706417619202152263L;
	WeekSelector weekSelector;
	
	public SeasonSelector(List<StatsTable> tables, ScheduleDAO dao, WeekSelector weekSelector) {
		super("Season", tables, dao);
		
		this.weekSelector = weekSelector;
		
		addListener(new SeasonSelectorListener());
		setWidth("70px");
		populate();
	}
	
	private class SeasonSelectorListener implements ValueChangeListener {

		private static final long serialVersionUID = 5439124626185999257L;

		@Override
		public void valueChange(com.vaadin.data.Property.ValueChangeEvent event) 
		{
			Season s = (Season) getValue();
			weekSelector.setSeason(s);
			weekSelector.populate();
		}		
	}

	@Override
	List<Object> getSelectionItems() {
		return dao.getSeasons();
	}
}
