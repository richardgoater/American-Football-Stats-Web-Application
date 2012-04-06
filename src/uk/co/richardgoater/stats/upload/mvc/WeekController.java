package uk.co.richardgoater.stats.upload.mvc;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import uk.co.richardgoater.stats.persistence.ScheduleWeek;

@RequestMapping(value = "/seasons/{seasonid}/week")
public class WeekController extends ScheduleDataController {

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody List<Object> addNewWeek(@RequestParam int weeknum, 
			@RequestParam String opponent, @RequestParam boolean isHome, 
			@PathVariable int seasonid) {
		scheduleDao.saveScheduleWeek(
				new ScheduleWeek(weeknum, opponent, null, true, seasonid));
		return scheduleDao.getScheduleWeeks(seasonid);
	}
	
	@RequestMapping(value = "/{weeknum}", method = RequestMethod.DELETE)
	public @ResponseBody List<Object> removeWeek(@PathVariable int weeknum, @PathVariable int seasonid) {
		scheduleDao.removeWeekAndData(weeknum, seasonid);
		return scheduleDao.getScheduleWeeks(seasonid);
	}
	
}
