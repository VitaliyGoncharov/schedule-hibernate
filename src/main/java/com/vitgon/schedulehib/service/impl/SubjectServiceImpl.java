package com.vitgon.schedulehib.service.impl;

import java.util.List;

import com.vitgon.schedulehib.model.Subject;
import com.vitgon.schedulehib.repository.SubjectRepository;
import com.vitgon.schedulehib.service.SubjectService;

public class SubjectServiceImpl implements SubjectService {

	private final SubjectRepository subjectRep;
	
	public SubjectServiceImpl(SubjectRepository subjectRep) {
		this.subjectRep = subjectRep;
	}
	
	@Override
	public Integer save(Subject obj) {
		return subjectRep.save(obj);
	}

	@Override
	public void update(Subject obj) {
		subjectRep.update(obj);
	}

	@Override
	public Subject findById(Integer id) {
		return subjectRep.findById(id);
	}

	@Override
	public List<Subject> findAll() {
		return subjectRep.findAll();
	}
	
	@Override
	public Subject findByTitle(String title) {
		return subjectRep.findByTitle(title);
	}
	
	@Override
	public Subject saveAndReturnEntity(Subject obj) {
		save(obj);
		return obj;
	}
}
