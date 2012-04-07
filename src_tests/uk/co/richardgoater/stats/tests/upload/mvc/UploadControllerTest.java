package uk.co.richardgoater.stats.tests.upload.mvc;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import uk.co.richardgoater.stats.tests.fake.FakeMultipartFile;
import uk.co.richardgoater.stats.upload.StatsLoader;
import uk.co.richardgoater.stats.upload.UploadResponse;
import uk.co.richardgoater.stats.upload.mvc.UploadController;
import uk.co.richardgoater.stats.upload.mvc.WebUploadResponse;

public class UploadControllerTest {

	private UploadController uploadController;
	private StatsLoader statsLoader;
	private String expectedMessage;
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
		expectedMessage = "Season: " + seasonid + " - Weeknum: " + weeknum;
		response = new WebUploadResponse();
		response.appendLine(expectedMessage);
		
		expect(statsLoader.load(file, seasonid, weeknum)).andReturn(response);
		replay(statsLoader);
		
		response = uploadController.postUpload(file, seasonid, weeknum);
	}
	
	@Test
	public void shouldReturnAResponse(){		
		Assert.assertNotNull(response);
	}
	
	@Test
	public void shouldReturnTheCorrectResponse(){
		Assert.assertTrue(response.getMessage().contains(expectedMessage));
	}
	
}