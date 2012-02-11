package uk.co.richardgoater.stats.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SEASON")
public class Season {
	
	private int seasonid;
	private String year;
	
	public Season()
	{
		super();
	}
	
	@Id
	@Column(name = "SEASONID")
	public int getSeasonid() {
		return seasonid;
	}

	public void setSeasonid(int seasonid) {
		this.seasonid = seasonid;
	}
	
	@Column(name = "YEAR")
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + seasonid;
		result = prime * result + ((year == null) ? 0 : year.hashCode());
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
		Season other = (Season) obj;
		if (seasonid != other.seasonid)
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}
	
	public String toString() {
		return year;
	}
	
}
