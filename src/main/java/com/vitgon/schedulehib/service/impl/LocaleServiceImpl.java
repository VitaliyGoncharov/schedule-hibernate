package com.vitgon.schedulehib.service.impl;

import java.util.List;

import com.vitgon.schedulehib.model.Locale;
import com.vitgon.schedulehib.repository.LocaleRepository;
import com.vitgon.schedulehib.service.LocaleService;


public class LocaleServiceImpl implements LocaleService {

	private final LocaleRepository localeRep;
	
	public LocaleServiceImpl(LocaleRepository localeRep) {
		this.localeRep = localeRep;
	}
	
	@Override
	public Integer save(Locale obj) {
		return localeRep.save(obj);
	}

	@Override
	public void update(Locale obj) {
		localeRep.update(obj);
	}

	@Override
	public Locale findById(Integer id) {
		return localeRep.findById(id);
	}

	@Override
	public List<Locale> findAll() {
		return localeRep.findAll();
	}

	@Override
	public Locale findByCode(String code) {
		return localeRep.findByCode(code);
	}
	
	@Override
	public Locale saveAndReturnEntity(Locale obj) {
		save(obj);
		return obj;
	}
}
