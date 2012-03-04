package uk.co.richardgoater.stats.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@SuppressWarnings("unused")
@Entity
@Table(name = "GAMEDATA_RECEIVING")
public class ReceivingGameData extends GameData {
	
	private int rec;
	private int yds;
	@Transient private double ydsPerRec;
	private int longest;
	private boolean isLongTD;
	@Transient private String displayLong;
	private int td;
	
	@Transient
	public String[] getVisibleColumns() {
		return new String[]{
				"player.name", "player.number", "player.position",
				"rec",
				"yds",
				"ydsPerRec",
				"displayLong",
				"td"
		};
	}
	
	public ReceivingGameData() {}
	
	public ReceivingGameData( Number playerid, Number rec,
			Number yds, Number longest, Number td)
	{
		this.playerid = playerid.intValue();
		this.rec = rec.intValue();
		this.yds = yds.intValue();
		this.longest = longest.intValue();
		this.td = td.intValue();
	}
	
	@Column(name = "REC")
	public int getRec() {
		return rec;
	}

	public void setRec(int rec) {
		this.rec = rec;
	}
	
	@Column(name = "YDS")
	public int getYds() {
		return yds;
	}

	public void setYds(int yds) {
		this.yds = yds;
	}
	
	@Transient
	public double getYdsPerRec() {
		return yds / rec;
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
