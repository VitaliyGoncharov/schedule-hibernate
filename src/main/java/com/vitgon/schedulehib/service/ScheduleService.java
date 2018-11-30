package com.vitgon.schedulehib.service;

import com.vitgon.schedulehib.model.Schedule;
import com.vitgon.schedulehib.service.base.Service;

public interface ScheduleService extends Service<Schedule, Integer>{
	Schedule saveAndReturnEntity(Schedule obj);
}
