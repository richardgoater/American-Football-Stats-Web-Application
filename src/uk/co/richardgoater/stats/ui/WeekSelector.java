package uk.co.richardgoater.stats.ui;

import java.util.List;

import uk.co.richardgoater.stats.persistence.ScheduleWeek;
import uk.co.richardgoater.stats.persistence.Season;
import uk.co.richardgoater.stats.persistence.dao.ScheduleDAO;
import uk.co.richardgoater.stats.ui.table.StatsTable;

import com.vaadin.data.Property;

public class WeekSelector extends AbstractSelector {

	private static final long serialVersionUID = -6167087394975397553L;
	Season season;
	
	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}
	
	public WeekSelector(List<StatsTable> tables, ScheduleDAO dao) {
		super("Week", tables, dao);
		
		addItem("<please select a season>");
		
		addListener(new WeekSelectorListener());
		setWidth("300px");
	}
	
	public class WeekSelectorListener implements Property.ValueChangeListener {

		private static final long serialVersionUID = -1357288653943959670L;

		public void valueChange(Property.ValueChangeEvent event) {
			
			if(getValue() instanceof ScheduleWeek) {
				ScheduleWeek week = (ScheduleWeek) getValue();
	
				for (StatsTable t : tables)
					t.setWeek(week);
			}
		}
	}

	@Override
	List<Object> getSelectionItems() {
		return dao.getScheduleWeeks(season.getSeasonid());
	}

	@Override
	protected void populate() {
		super.populate();
		clearTables();		
		selectFirstItem();
	}
	
}
