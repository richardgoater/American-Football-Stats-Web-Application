package uk.co.richardgoater.stats.tests.fake;

import uk.co.richardgoater.stats.upload.excel.ExcelRow;

public class FakeExcelRow implements ExcelRow {

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

}
