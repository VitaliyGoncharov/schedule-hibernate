package com.vitgon.schedulehib.service.impl;

import java.util.List;

import com.vitgon.schedulehib.model.Major;
import com.vitgon.schedulehib.repository.MajorRepository;
import com.vitgon.schedulehib.service.MajorService;

public class MajorServiceImpl implements MajorService {

	private final MajorRepository majorRep;
	
	public MajorServiceImpl(MajorRepository majorRep) {
		this.majorRep = majorRep;
	}
	
	@Override
	public Integer save(Major obj) {
		return majorRep.save(obj);
	}

	@Override
	public void update(Major obj) {
		majorRep.update(obj);
	}

	@Override
	public Major findById(Integer id) {
		return majorRep.findById(id);
	}

	@Override
	public List<Major> findAll() {
		return majorRep.findAll();
	}
	
	@Override
	public Major saveAndReturnEntity(Major obj) {
		save(obj);
		return obj;
	}

	@Override
	public Major findByTitle(String title) {
		return majorRep.findByTitle(title);
	}
}
