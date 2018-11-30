package com.vitgon.schedulehib.service.impl;

import java.util.List;

import com.vitgon.schedulehib.model.Schedule;
import com.vitgon.schedulehib.repository.ScheduleRepository;
import com.vitgon.schedulehib.service.ScheduleService;

public class ScheduleServiceImpl implements ScheduleService {
	
	private final ScheduleRepository scheduleRep;
	
	public ScheduleServiceImpl(ScheduleRepository scheduleRep) {
		this.scheduleRep = scheduleRep;
	}
	
	@Override
	public Integer save(Schedule obj) {
		return scheduleRep.save(obj);
	}

	@Override
	public void update(Schedule obj) {
		scheduleRep.update(obj);
	}

	@Override
	public Schedule findById(Integer id) {
		return scheduleRep.findById(id);
	}

	@Override
	public List<Schedule> findAll() {
		return scheduleRep.findAll();
	}
	
	@Override
	public Schedule saveAndReturnEntity(Schedule obj) {
		save(obj);
		return obj;
	}
}
