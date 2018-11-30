package com.vitgon.schedulehib.repository.impl;

import org.hibernate.SessionFactory;

import com.vitgon.schedulehib.model.Teacher;
import com.vitgon.schedulehib.repository.TeacherRepository;
import com.vitgon.schedulehib.repository.impl.base.BaseRepository;

public class TeacherRepositoryImpl extends BaseRepository<Teacher, Integer> implements TeacherRepository {

	public TeacherRepositoryImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
