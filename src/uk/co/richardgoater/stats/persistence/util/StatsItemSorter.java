package uk.co.richardgoater.stats.persistence.util;

import java.util.Comparator;

import uk.co.richardgoater.stats.persistence.GameDataWithLongest;

import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.DefaultItemSorter;

public class StatsItemSorter extends DefaultItemSorter {

	private static final long serialVersionUID = -1021302714350094366L;

	Comparator<Object> comparator = new DefaultPropertyValueComparator();
	Object longestPropertyID = "displayLong";
	
	@Override
	protected int compareProperty(Object propertyId, boolean sortDirection,
			Item item1, Item item2) {
		
		if(propertyId.equals(longestPropertyID)) {
			return sortLongestProperty(sortDirection, item1, item2);
		} else {
			return super.compareProperty(propertyId, sortDirection, item1, item2);
		}
		
	}

	private int sortLongestProperty(boolean sortDirection, Item item1,
			Item item2) {
		final Property property1 = item1.getItemProperty(longestPropertyID);
        final Property property2 = item2.getItemProperty(longestPropertyID);

        // Get the values to compare
        final Object value1 = (property1 == null) ? null : convertStringToInt(property1.getValue());
        final Object value2 = (property2 == null) ? null : convertStringToInt(property2.getValue());

        // Result of the comparison
        int r = 0;
        if (sortDirection) {
            r = comparator.compare(value1, value2);
        } else {
            r = comparator.compare(value2, value1);
        }
        return r;
		
	}

	private Object convertStringToInt(Object value) {
		
		String stringValue = (String) value;
		if(stringValue.endsWith(GameDataWithLongest.touchdownIndicator)) {
			stringValue = stringValue.substring(stringValue.length()-1);
		}
		return new Integer(Integer.parseInt(stringValue));
	}	

}
