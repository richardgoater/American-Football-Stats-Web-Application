package uk.co.richardgoater.stats.upload.excel.jxl;

import uk.co.richardgoater.stats.upload.excel.ExcelCell;
import uk.co.richardgoater.stats.upload.excel.ExcelRow;

public class JxlRow implements ExcelRow {

	int seasonid;
	int weeknum;
	
	@Override
	public String asString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSeasonid() {
		return seasonid;
	}

	@Override
	public int getWeeknum() {
		return weeknum;
	}

	@Override
	public void setScheduleData(int seasonid, int weeknum) {
		this.seasonid = seasonid;
		this.weeknum = weeknum;
	}

	@Override
	public ExcelCell nextCell() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void resetIterator() {
		// TODO Auto-generated method stub
		
	}

}
