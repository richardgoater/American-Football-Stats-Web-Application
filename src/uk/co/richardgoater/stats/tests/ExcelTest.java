package uk.co.richardgoater.stats.tests;


import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.web.multipart.MultipartFile;

public class ExcelTest {

	ApplicationContext context;
	File f;
	Workbook wb;
	
	public ExcelTest() {
//		context = new ClassPathXmlApplicationContext("uk/co/richardgoater/stats/tests/Spring-test.xml");
	}
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void fileTest() {
		f = new File("C:\\Users\\Public\\Documents\\Watford Cheetahs Stats\\2011_season_stats.xls");
		Assert.assertNotNull(f);		
	}
	
	@Test
	public void workbookTest() throws BiffException, IOException {
		fileTest();
		wb = Workbook.getWorkbook(f);
		Assert.assertNotNull(wb);
	}
	
	@Test
	public void cellTest() throws BiffException, IOException {
		workbookTest();
		Sheet sheet = wb.getSheet("Defence");
		Assert.assertNotNull(sheet);
		
		Cell a11 = sheet.getCell("A11");
		Assert.assertNotNull(a11);
		Assert.assertEquals("Mark Foster", a11.getContents());
	}
	
	@Test
	public void fileNameFormatTest() {
		fileTest();
		
		String fileName = f.getName();
		System.out.println(fileName);
		
		Pattern fileNamePattern = Pattern.compile("\\d{4}_\\w*_\\w*.xls");
		Matcher m = fileNamePattern.matcher(fileName);
		Assert.assertTrue(m.matches());
	}
	
	

}
