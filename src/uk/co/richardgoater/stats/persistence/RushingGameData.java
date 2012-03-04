package uk.co.richardgoater.stats.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@SuppressWarnings("unused")
@Entity
@Table(name = "GAMEDATA_RUSHING")
public class RushingGameData extends GameData {
	
	private int att;
	private int yds;
	@Transient private double ydsPerAtt;
	private int longest;
	private boolean isLongTD;
	@Transient private String displayLong;
	private int td;
	
	@Transient
	public String[] getVisibleColumns() {
		return new String[]{
				"player.name", "player.number", "player.position",
				"att",
				"yds",
				"ydsPerAtt",
				"displayLong",
				"td"
		};
	}
	
	public RushingGameData() {}
	
	public RushingGameData( Number playerid, Number att,
			Number yds, Number longest, Number td)
	{
		this.playerid = playerid.intValue();
		this.att = att.intValue();
		this.yds = yds.intValue();
		this.longest = longest.intValue();
		this.td = td.intValue();
	}
	
	@Column(name = "ATT")
	public int getAtt() {
		return att;
	}

	public void setAtt(int att) {
		this.att = att;
	}
	
	@Column(name = "YDS")
	public int getYds() {
		return yds;
	}

	public void setYds(int yds) {
		this.yds = yds;
	}
	
	@Transient
	public double getYdsPerAtt() {
		return yds / att;
	}
	
	@Column(name = "LONGEST")
	public int getLongest() {
		return longest;
	}

	public void setLongest(int longest) {
		this.longest = longest;
	}
	
	@Column(name = "TD")
	public int getTd() {
		return td;
	}

	public void setTd(int td) {
		this.td = td;
	}
	
	@Transient
	public String getDisplayLong() {
		return LongUtility.getLong(longest, isLongTD);
	}

	@Column(name = "ISLONGTD")
	public boolean isLongTD() {
		return isLongTD;
	}
	
	public void setLongTD(boolean isLongTD) {
		this.isLongTD = isLongTD;
	}
}
