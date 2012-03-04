package uk.co.richardgoater.stats.tests.upload;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import uk.co.richardgoater.stats.tests.fake.FakeMultipartFile;
import uk.co.richardgoater.stats.upload.StatsLoader;
import uk.co.richardgoater.stats.upload.UploadController;
import uk.co.richardgoater.stats.upload.UploadResponse;

public class UploadControllerTest {

	private UploadController uploadController;
	private StatsLoader statsLoader;
	private String expectedResult;
	
	private FakeMultipartFile file;
	
	int seasonid = 1;
	int weeknum = 2;
	
	@Before
	public void setup(){
		uploadController = new UploadController();
		statsLoader = createMock(StatsLoader.class);
		uploadController.setStatsLoader(statsLoader);
		file = new FakeMultipartFile();
		expectedResult = "Season: " + seasonid + " - Weeknum: " + weeknum;
		
		expect(statsLoader.load(file, seasonid, weeknum)).andReturn(expectedResult);
		replay(statsLoader);
	}
	
	@Test
	public void shouldReturnAResponse(){		
		UploadResponse response = uploadController.postUpload(file, seasonid, weeknum);
		Assert.assertNotNull(response);
	}
	
	@Test
	public void shouldReturnTheCorrectResponse(){
		UploadResponse response = uploadController.postUpload(file, seasonid, weeknum);
		Assert.assertTrue(response.getResult().contains(expectedResult));
	}
	
	@Test
	public void shouldReturnAFailedResponseWhenFileIsEmpty(){
		file.isEmpty(true);
		UploadResponse response = uploadController.postUpload(file, seasonid, weeknum);
		Assert.assertEquals("There was a problem with the upload. Soz.", response.getResult());
	}
	
}