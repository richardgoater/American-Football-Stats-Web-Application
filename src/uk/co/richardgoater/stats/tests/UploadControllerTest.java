package uk.co.richardgoater.stats.tests;

import static org.easymock.EasyMock.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import uk.co.richardgoater.stats.StatsLoader;
import uk.co.richardgoater.stats.upload.UploadController;
import uk.co.richardgoater.stats.upload.UploadResponse;

public class UploadControllerTest {

	private UploadController uploadController;
	private StatsLoader statsLoader;
	private String expectedResult;
	
	private TestFile file;
	
	String season = "2011";
	int weeknum = 2;
	
	@Before
	public void setup(){
		uploadController = new UploadController();
		statsLoader = createMock(StatsLoader.class);
		uploadController.setStatsLoader(statsLoader);
		file = new TestFile();
		expectedResult = "Season: " + season + " - Weeknum: " + weeknum;
		
//		expect(statsLoader.load(file)).andReturn(expectedResult);
//		replay(statsLoader);
	}
	
	@Test
	public void should_return_a_response(){		
		UploadResponse response = uploadController.postUpload(file, season, weeknum);
		Assert.assertNotNull(response);
	}
	
	@Test
	public void shouldReturnTheCorrectResponse(){
		UploadResponse response = uploadController.postUpload(file, season, weeknum);
		Assert.assertTrue(response.getResult().contains(expectedResult));
	}
	
	@Test
	public void should_return_a_failed_response_when_file_is_empty(){
		file.isEmpty(true);
		UploadResponse response = uploadController.postUpload(file, season, weeknum);
		Assert.assertEquals("There was a problem with the upload. Soz.", response.getResult());
	}
	
}