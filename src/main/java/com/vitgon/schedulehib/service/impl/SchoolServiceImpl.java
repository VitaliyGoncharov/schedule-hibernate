package com.vitgon.schedulehib.service.impl;

import java.util.List;

import com.vitgon.schedulehib.model.School;
import com.vitgon.schedulehib.repository.SchoolRepository;
import com.vitgon.schedulehib.service.SchoolService;

public class SchoolServiceImpl implements SchoolService {
	
	private final SchoolRepository schoolRep;
	
	public SchoolServiceImpl(SchoolRepository schoolRepository) {
		this.schoolRep = schoolRepository;
	}
	
	@Override
	public Integer save(School obj) {
		return schoolRep.save(obj);
	}

	@Override
	public void update(School obj) {
		schoolRep.update(obj);
	}

	@Override
	public School findById(Integer id) {
		return schoolRep.findById(id);
	}

	@Override
	public List<School> findAll() {
		return schoolRep.findAll();
	}

	@Override
	public School findByTitle(String title) {
		return schoolRep.findByTitle(title);
	}
	
	@Override
	public School saveAndReturnEntity(School obj) {
		save(obj);
		return obj;
	}
}
