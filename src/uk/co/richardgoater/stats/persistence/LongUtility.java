package uk.co.richardgoater.stats.persistence;

public class LongUtility {
	
	public static String getLong(int longest, boolean wasTD) {
		String displayLong = Integer.toString(longest);
		
		if(wasTD)
			displayLong += "T";
		
		return displayLong;
	}
	
}
