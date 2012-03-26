package uk.co.richardgoater.stats.upload;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import uk.co.richardgoater.stats.persistence.dao.ScheduleDAO;


@Controller
@RequestMapping(value = "/")
public class UploadController {

	StatsLoader statsLoader;
	ScheduleDAO scheduleDao;
	
	public void setStatsLoader(StatsLoader statsLoader) {
		this.statsLoader = statsLoader;
	}
	
	public void setScheduleDao(ScheduleDAO scheduleDao) {
		this.scheduleDao = scheduleDao;
	}

	@RequestMapping(value = "seasons/{seasonid}", method = RequestMethod.GET)
	public @ResponseBody List<Object> getWeeksForSeason(@PathVariable int seasonid) {
		return scheduleDao.getScheduleWeeks(seasonid);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView initialisePage() {
		ModelAndView modelAndView = new ModelAndView("upload");
		modelAndView.addObject("seasons", scheduleDao.getSeasons());
		return modelAndView;
	}

	@RequestMapping(value="upload", method = RequestMethod.POST)
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
