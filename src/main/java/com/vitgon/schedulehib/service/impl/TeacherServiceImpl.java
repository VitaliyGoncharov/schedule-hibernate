package com.vitgon.schedulehib.service.impl;

import java.util.List;

import com.vitgon.schedulehib.model.Teacher;
import com.vitgon.schedulehib.repository.TeacherRepository;
import com.vitgon.schedulehib.service.TeacherService;

public class TeacherServiceImpl implements TeacherService {

	private final TeacherRepository teacherRep;
	
	public TeacherServiceImpl(TeacherRepository teacherRep) {
		this.teacherRep = teacherRep;
	}

	@Override
	public Integer save(Teacher obj) {
		return teacherRep.save(obj);
	}

	@Override
	public void update(Teacher obj) {
		teacherRep.update(obj);
	}

	@Override
	public Teacher findById(Integer id) {
		return teacherRep.findById(id);
	}

	@Override
	public List<Teacher> findAll() {
		return teacherRep.findAll();
	}

	@Override
	public Teacher saveAndReturnEntity(Teacher obj) {
		save(obj);
		return obj;
	}
}
