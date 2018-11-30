package com.vitgon.schedulehib.repository.impl;

import org.hibernate.SessionFactory;

import com.vitgon.schedulehib.model.Schedule;
import com.vitgon.schedulehib.repository.ScheduleRepository;
import com.vitgon.schedulehib.repository.impl.base.BaseRepository;

public class ScheduleRepositoryImpl extends BaseRepository<Schedule, Integer> implements ScheduleRepository {
	
	public ScheduleRepositoryImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
