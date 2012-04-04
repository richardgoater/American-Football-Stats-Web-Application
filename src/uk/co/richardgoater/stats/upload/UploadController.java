package uk.co.richardgoater.stats.upload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class UploadController {

	StatsLoader statsLoader;
	
	public void setStatsLoader(StatsLoader statsLoader) {
		this.statsLoader = statsLoader;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String initialisePage() {
		return "upload";
	}

	@RequestMapping(value="/upload", method = RequestMethod.POST)
	public @ResponseBody
	UploadResponse postUpload(@RequestParam("file") MultipartFile file,
			@RequestParam("season") int seasonid,
			@RequestParam("weeknum") int weeknum) {

		if (!file.isEmpty()) {
			String result = statsLoader.load(file, seasonid, weeknum);
			return new UploadResponse(result);
		} else {
			return new UploadResponse("There was a problem with the upload. Soz.");
		}
	}
}
