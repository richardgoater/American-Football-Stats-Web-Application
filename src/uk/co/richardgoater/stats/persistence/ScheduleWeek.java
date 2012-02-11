package uk.co.richardgoater.stats.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "SCHEDULE")
public class ScheduleWeek {
	
	private int scheduleid;
	private int weeknum;
	private String opponent;
	private Date date;
	private boolean isHome;
	private int seasonid;
	
	public ScheduleWeek()
	{
		super();
	}
	
	public ScheduleWeek(int weeknum, String opponent, Date date, boolean isHome, int seasonid) {
		super();
		this.weeknum = weeknum;
		this.opponent = opponent;
		this.date = date;
		this.isHome = isHome;
		this.seasonid = seasonid;
	}
	
	@Id
	@GeneratedValue
	@Column(name = "SCHEDULEID")
	public int getScheduleID() {
		return scheduleid;
	}
	
	public void setScheduleID(int s) {
		scheduleid = s;
	}
	
	@Column(name = "WEEKNUM")
	public int getWeeknum() {
		return weeknum;
	}

	public void setWeeknum(int weeknum) {
		this.weeknum = weeknum;
	}
	
	@Column(name = "OPPONENT")
	public String getOpponent() {
		return opponent;
	}

	public void setOpponent(String opponent) {
		this.opponent = opponent;
	}
	
	@Column(name = "DATE")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@Column(name = "ISHOME")
	public boolean isHome() {
		return isHome;
	}

	public void setHome(boolean isHome) {
		this.isHome = isHome;
	}
	
	@Transient
	public String getDisplayName() {

		if (getWeeknum() == 0) {
			return "All";
		} else {
			String dn = "Week " + getWeeknum() + " - ";

			if (isHome()) {
				dn += getOpponent();
			} else {
				dn += "@" + getOpponent();
			}
			return dn;
		}
	}
	
	@Column(name = "SEASONID")
	public int getSeasonID() {
		return seasonid;
	}
	
	public void setSeasonID(int seasonid) {
		this.seasonid = seasonid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + (isHome ? 1231 : 1237);
		result = prime * result
				+ ((opponent == null) ? 0 : opponent.hashCode());
		result = prime * result + scheduleid;
		result = prime * result + seasonid;
		result = prime * result + weeknum;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScheduleWeek other = (ScheduleWeek) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (isHome != other.isHome)
			return false;
		if (opponent == null) {
			if (other.opponent != null)
				return false;
		} else if (!opponent.equals(other.opponent))
			return false;
		if (scheduleid != other.scheduleid)
			return false;
		if (seasonid != other.seasonid)
			return false;
		if (weeknum != other.weeknum)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return getDisplayName();
	}
	
}
