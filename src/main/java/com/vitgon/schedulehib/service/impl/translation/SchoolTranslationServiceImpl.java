package com.vitgon.schedulehib.service.impl.translation;

import java.util.List;

import com.vitgon.schedulehib.model.translation.SchoolTranslation;
import com.vitgon.schedulehib.model.translation.pk.SchoolTranslationId;
import com.vitgon.schedulehib.repository.translation.SchoolTranslationRepository;
import com.vitgon.schedulehib.service.translation.SchoolTranslationService;

public class SchoolTranslationServiceImpl implements SchoolTranslationService {

	private final SchoolTranslationRepository schoolTranslRep;
	
	public SchoolTranslationServiceImpl(SchoolTranslationRepository schoolTranslRep) {
		this.schoolTranslRep = schoolTranslRep;
	}
	
	@Override
	public SchoolTranslationId save(SchoolTranslation obj) {
		return schoolTranslRep.save(obj);
	}

	@Override
	public void update(SchoolTranslation obj) {
		schoolTranslRep.update(obj);
	}

	@Override
	public SchoolTranslation findById(SchoolTranslationId id) {
		return schoolTranslRep.findById(id);
	}

	@Override
	public List<SchoolTranslation> findAll() {
		return schoolTranslRep.findAll();
	}
	
	@Override
	public SchoolTranslation saveAndReturnEntity(SchoolTranslation obj) {
		save(obj);
		return obj;
	}
}
