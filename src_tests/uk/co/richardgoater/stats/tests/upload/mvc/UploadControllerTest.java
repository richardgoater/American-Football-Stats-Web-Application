package uk.co.richardgoater.stats.tests.upload.mvc;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import uk.co.richardgoater.stats.tests.fake.FakeMultipartFile;
import uk.co.richardgoater.stats.upload.StatsLoader;
import uk.co.richardgoater.stats.upload.mvc.UploadController;
import uk.co.richardgoater.stats.upload.mvc.UploadResponse;

public class UploadControllerTest {

	private UploadController uploadController;
	private StatsLoader statsLoader;
	private String expectedResult;
	private UploadResponse response;
	
	private FakeMultipartFile file;
	
	int seasonid = 1;
	int weeknum = 3;
	
	@Before
	public void setup(){
		uploadController = new UploadController();
		statsLoader = createMock(StatsLoader.class);
		uploadController.setStatsLoader(statsLoader);
		file = new FakeMultipartFile();
		expectedResult = "Season: " + seasonid + " - Weeknum: " + weeknum;
		
		expect(statsLoader.load(file, seasonid, weeknum)).andReturn(expectedResult);
		replay(statsLoader);
		
		response = uploadController.postUpload(file, seasonid, weeknum);
	}
	
	@Test
	public void shouldReturnAResponse(){		
		Assert.assertNotNull(response);
	}
	
	@Test
	public void shouldReturnTheCorrectResponse(){
		Assert.assertTrue(response.getResult().contains(expectedResult));
	}
	
	@Test
	public void shouldReturnAFailedResponseWhenFileIsEmpty(){
		file.isEmpty(true);
		UploadResponse failResponse = uploadController.postUpload(file, seasonid, weeknum);
		Assert.assertEquals("There was a problem with the upload. Soz.", failResponse.getResult());
	}
	
}