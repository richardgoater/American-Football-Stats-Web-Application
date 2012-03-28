package uk.co.richardgoater.stats.tests.upload;

import static org.junit.Assert.*;

import java.io.IOException;

import jxl.Cell;
import jxl.read.biff.BiffException;

import org.junit.Before;
import org.junit.Test;

import uk.co.richardgoater.stats.upload.excel.ExcelCell;
import uk.co.richardgoater.stats.upload.excel.jxl.JxlRow;

public class JxlRowTest extends JxlTest {

	private JxlRow row;
	
	@Before
	public void setUp() throws BiffException, IOException {
		setUpMocks();
		setExpectations();
		
		row = new JxlRow(getCells(), 1);
	}

	private void setUpMocks() {
		// TODO Auto-generated method stub
		
	}

	private void setExpectations() {
		// TODO Auto-generated method stub
		
	}
	
	@Test
	public void getsFirstCell() throws BiffException, IOException {
		ExcelCell cell = row.nextCell();
		assertEquals(getCells()[0].getContents(), cell.asString() );
	}
	
	@Test
	public void getsSecondCell() throws BiffException, IOException {
		row.nextCell();
		ExcelCell cell = row.nextCell();
		assertEquals(getCells()[1].getContents(), cell.asString() );
	}
	
	@Test
	public void getsFinalCell() throws BiffException, IOException {
		ExcelCell cell = null;
		Cell[] cellArray = getCells();
		for(int  i = 0; i < cellArray.length; i++) {
			cell = row.nextCell();
		}
		assertEquals(cellArray[cellArray.length-1].getContents(), cell.asString() );
	}
	
	@Test
	public void returnsRowAsStringCorrectly() {
		String expectedRowAsString = "Dave Bright 8 7 1 2 6 0 0 0 0 1 0 0 0 0 0";
		assertEquals(expectedRowAsString, row.asString());
	}
}

