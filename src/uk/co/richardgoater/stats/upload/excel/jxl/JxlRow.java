package uk.co.richardgoater.stats.upload.excel.jxl;

import java.util.Arrays;
import java.util.Iterator;

import jxl.Cell;
import uk.co.richardgoater.stats.upload.excel.ExcelCell;
import uk.co.richardgoater.stats.upload.excel.ExcelRow;

public class JxlRow implements ExcelRow {
	
	Cell[] cells;
	Iterator<Cell> cellIterator;
	
	int seasonid;
	int weeknum;
	
	public JxlRow(Cell[] cells) {
		this.cells = cells;
	}
	
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
		if(cellIterator == null)
			cellIterator = Arrays.asList(cells).iterator();
		return new JxlCell(cellIterator.next());
	}

	@Override
	public void resetIterator() {
		cellIterator = Arrays.asList(cells).iterator();		
	}

}
