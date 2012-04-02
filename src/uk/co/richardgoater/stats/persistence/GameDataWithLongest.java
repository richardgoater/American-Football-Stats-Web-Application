package uk.co.richardgoater.stats.persistence;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public abstract class GameDataWithLongest extends GameData {
	
	private String touchdownIndicator = "T";
	
	protected int longest;
	private boolean isLongTD;
	@SuppressWarnings("unused")
	@Transient private String displayLong;
	
	@Column(name = "LONGEST")
	public int getLongest() {
		return longest;
	}

	public void setLongest(int longest) {
		this.longest = longest;
	}
	
	@Column(name = "ISLONGTD")
	//@Type(type = "true_false")
	public boolean isLongTD() {
		return isLongTD;
	}
	
	public void setLongTD(boolean isLongTD) {
		this.isLongTD = isLongTD;
	}
	
	@Transient
	public String getDisplayLong() {
		return getLongestAsString(longest, isLongTD);
	}
	
	public String getLongestAsString(int longest, boolean wasTD) {
		String displayLong = Integer.toString(longest);
		
		if(wasTD)
			displayLong += touchdownIndicator;
		
		return displayLong;
	}
	
	public void setLongStats(String longestAsString) {
		longest = getLongest(longestAsString);
		isLongTD = wasTD(longestAsString);
	}
	
	public int getLongest(String longestAsString) {
		return Integer.parseInt(longestAsString.toUpperCase().replace(touchdownIndicator, ""));
	}
	
	public boolean wasTD(String longestAsString) {
		return longestAsString.toUpperCase().endsWith(touchdownIndicator);
	}
	
}
