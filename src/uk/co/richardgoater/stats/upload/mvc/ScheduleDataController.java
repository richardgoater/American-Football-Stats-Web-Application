package uk.co.richardgoater.stats.upload.mvc;

import org.springframework.stereotype.Controller;

import uk.co.richardgoater.stats.persistence.dao.ScheduleDAO;

@Controller
public class ScheduleDataController {
	
	ScheduleDAO scheduleDao;
	
	public void setScheduleDao(ScheduleDAO scheduleDao) {
		this.scheduleDao = scheduleDao;
	}
	
}
