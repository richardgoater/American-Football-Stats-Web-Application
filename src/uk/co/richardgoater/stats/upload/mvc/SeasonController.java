package uk.co.richardgoater.stats.upload.mvc;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import uk.co.richardgoater.stats.persistence.Season;

@RequestMapping(value = "/seasons")
public class SeasonController extends ScheduleDataController {

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Object> getSeasons() {
		return scheduleDao.getSeasons();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody List<Object> addNewSeason(@RequestParam int newID, @RequestParam String season) {
		scheduleDao.saveSeason(new Season(newID, season));
		return scheduleDao.getSeasons();
	}
	
	@RequestMapping(value = "/{seasonid}", method = RequestMethod.GET)
	public @ResponseBody List<Object> getWeeksForSeason(@PathVariable int seasonid) {
		return scheduleDao.getScheduleWeeks(seasonid);
	}
	
	@RequestMapping(value = "/{seasonid}", method = RequestMethod.DELETE)
	public @ResponseBody List<Object> removeSeason(@PathVariable int seasonid) {
		scheduleDao.removeSeasonAndData(seasonid);
		return scheduleDao.getSeasons();
	}
	
}
