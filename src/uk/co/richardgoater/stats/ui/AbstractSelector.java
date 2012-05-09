package uk.co.richardgoater.stats.ui;

import java.util.List;

import uk.co.richardgoater.stats.persistence.dao.ScheduleDAO;
import uk.co.richardgoater.stats.ui.table.StatsTable;

import com.vaadin.ui.ComboBox;

public abstract class AbstractSelector extends ComboBox {

	private static final long serialVersionUID = 6868269254843254452L;
	List<StatsTable> tables;
	ScheduleDAO dao;
	
	public AbstractSelector(String caption, List<StatsTable> tables, ScheduleDAO dao) {
		super(caption);
		this.tables = tables;
		this.dao = dao;
		
		setNullSelectionAllowed(false);
		setFilteringMode(FILTERINGMODE_CONTAINS);
		setImmediate(true);
	}
	
	abstract List<Object> getSelectionItems();
	
	protected void populate() {
		removeAllItems();
		for (Object i : getSelectionItems()) {
			addItem(i);
		}
		pageLength = items.size();
	}
	
	protected void selectFirstItem() {
		Object firstItemID = getItemIds().toArray()[0];
		if(firstItemID != null)
			setValue(firstItemID);
	}
	
	protected void clearTables() {
		for (StatsTable t : tables) {
			t.removeAllItems();
			t.setSortContainerPropertyId(null);
		}
	}
}
