package uk.co.richardgoater.stats.ui;

import uk.co.richardgoater.stats.ui.table.DefenseTable;

import com.vaadin.data.Property;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.ColumnGenerator;

@SuppressWarnings("serial")
public class StatsColumnGenerator implements ColumnGenerator {

	public StatsColumnGenerator() {
		System.out.println("STATSCOLUMNGENERATOR");
	}

	
	public Component generateCell(Table source, Object itemId, Object columnId) {

		// Defense generated columns
		if (source instanceof DefenseTable) {
			
			// Yards per Int
			if (columnId.equals("YDS/INT")) {
				Property yards = source.getItem(itemId).getItemProperty("YDS");
				Property ints = source.getItem(itemId).getItemProperty("INTS");

				int yardsNum = new Integer((String) yards.getValue());
				int intsNum = new Integer((String) ints.getValue());
				
				System.out.println("YDS/INT: " + new Double(yardsNum / intsNum).toString());
				
				return new Label(new Double(yardsNum / intsNum).toString());
			} else
				System.out.println("not YDS/INT");
		} else 
			System.out.println("not defensetable");
		return new Label("ERROR");
	}

}
