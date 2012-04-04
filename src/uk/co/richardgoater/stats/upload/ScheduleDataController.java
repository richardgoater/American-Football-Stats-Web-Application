package uk.co.richardgoater.stats.upload;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import uk.co.richardgoater.stats.persistence.ScheduleWeek;
import uk.co.richardgoater.stats.persistence.Season;
import uk.co.richardgoater.stats.persistence.dao.ScheduleDAO;

@Controller
@RequestMapping(value = "/seasons")
public class ScheduleDataController {
	
	ScheduleDAO scheduleDao;
	
	public void setScheduleDao(ScheduleDAO scheduleDao) {
		this.scheduleDao = scheduleDao;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Object> getSeasons() {
		return scheduleDao.getSeasons();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody List<Object> addNewSeason(@RequestParam int newID, @RequestParam String season) {
		scheduleDao.saveSeason(new Season(newID, season));
		return scheduleDao.getSeasons();
	}
	
	@RequestMapping(value = "/{seasonid}", method = RequestMethod.DELETE)
	public @ResponseBody List<Object> removeSeason(@PathVariable int seasonid) {
		scheduleDao.removeSeasonAndData(seasonid);
		return scheduleDao.getSeasons();
	}
	
	@RequestMapping(value = "/{seasonid}", method = RequestMethod.GET)
	public @ResponseBody List<Object> getWeeksForSeason(@PathVariable int seasonid) {
		return scheduleDao.getScheduleWeeks(seasonid);
	}

}
