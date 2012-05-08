package uk.co.richardgoater.stats.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@SuppressWarnings("unused")
@Entity
@Table(name = "PLAYER")
public class Player {
	
	private int playeruid;
	private int playerid;
	private String name;
	@Transient private String displayName;
	private int number;
	@Transient private String displayNumber;
	private String position;
	private boolean isCaptain;
	private boolean isPassing;
	private boolean isRushing;
	private boolean isReceiving;
	private boolean isDefense;
	private int seasonid;
	
	public Player()
	{
		super();
	}
	
	public Player(String name, int number, String position, boolean isCaptain) {
		super();
		this.name = name;
		this.number = number;
		this.position = position;
		this.isCaptain = isCaptain;
	}

	@Id
	@GeneratedValue
	@Column(name = "PLAYERUID")	
	public int getPlayeruid() {
		return playeruid;
	}

	public void setPlayeruid(int playeruid) {
		this.playeruid = playeruid;
	}
	
	@Column(name = "PLAYERID")	
	public int getPlayerid() {
		return playerid;
	}

	public void setPlayerid(int playerid) {
		this.playerid = playerid;
	}
	
	@Column(name = "NAME")
	public String getName() {
		return name; 
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Transient
	public String getDisplayName() {
		String captainInd = " (c)";
		if(isCaptain && !name.endsWith(captainInd))
			return name + captainInd;
		else
			return name;
	}
	
	@Column(name = "NUMBER")
	public int getNumber() {
		return number;
	}	
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	@Transient
	public String getDisplayNumber() {
		if(number == 0)
			return "";
		else
			return "" + number;
	}
	
	@Column(name = "POSITION")
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void setCaptain(boolean isCaptain) {
		this.isCaptain = isCaptain;
	}
	
	@Column(name = "ISCAPTAIN")
	public boolean isCaptain() {
		return isCaptain;
	}
	
	@Column(name = "ISPASSING")
	public boolean isPassing() {
		return isPassing;
	}

	public void setPassing(boolean isPassing) {
		this.isPassing = isPassing;
	}
	
	@Column(name = "ISRUSHING")
	public boolean isRushing() {
		return isRushing;
	}

	public void setRushing(boolean isRushing) {
		this.isRushing = isRushing;
	}
	
	@Column(name = "ISRECEIVING")
	public boolean isReceiving() {
		return isReceiving;
	}

	public void setReceiving(boolean isReceiving) {
		this.isReceiving = isReceiving;
	}
	
	@Column(name = "ISDEFENSE")
	public boolean isDefense() {
		return isDefense;
	}

	public void setDefense(boolean isDefense) {
		this.isDefense = isDefense;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isCaptain ? 1231 : 1237);
		result = prime * result + (isDefense ? 1231 : 1237);
		result = prime * result + (isPassing ? 1231 : 1237);
		result = prime * result + (isReceiving ? 1231 : 1237);
		result = prime * result + (isRushing ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + number;
		result = prime * result + playerid;
		result = prime * result + playeruid;
		result = prime * result
				+ ((position == null) ? 0 : position.hashCode());
		result = prime * result + seasonid;
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
		Player other = (Player) obj;
		if (isCaptain != other.isCaptain)
			return false;
		if (isDefense != other.isDefense)
			return false;
		if (isPassing != other.isPassing)
			return false;
		if (isReceiving != other.isReceiving)
			return false;
		if (isRushing != other.isRushing)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number != other.number)
			return false;
		if (playerid != other.playerid)
			return false;
		if (playeruid != other.playeruid)
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (seasonid != other.seasonid)
			return false;
		return true;
	}

	public void setSeasonid(int seasonid) {
		this.seasonid = seasonid;
	}

	@Column(name = "SEASONID")
	public int getSeasonid() {
		return seasonid;
	}	
	
}
