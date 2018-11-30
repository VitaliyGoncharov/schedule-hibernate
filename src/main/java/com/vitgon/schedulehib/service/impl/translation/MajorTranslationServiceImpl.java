package com.vitgon.schedulehib.service.impl.translation;

import java.util.List;

import com.vitgon.schedulehib.model.translation.MajorTranslation;
import com.vitgon.schedulehib.model.translation.pk.MajorTranslationId;
import com.vitgon.schedulehib.repository.translation.MajorTranslationRepository;
import com.vitgon.schedulehib.service.translation.MajorTranslationService;

public class MajorTranslationServiceImpl implements MajorTranslationService {

	private final MajorTranslationRepository majorTranslRep;
	
	public MajorTranslationServiceImpl(MajorTranslationRepository majorTranslRep) {
		this.majorTranslRep = majorTranslRep;
	}
	
	@Override
	public MajorTranslationId save(MajorTranslation obj) {
		return majorTranslRep.save(obj);
	}

	@Override
	public void update(MajorTranslation obj) {
		majorTranslRep.update(obj);
	}

	@Override
	public MajorTranslation findById(MajorTranslationId id) {
		return majorTranslRep.findById(id);
	}

	@Override
	public List<MajorTranslation> findAll() {
		return majorTranslRep.findAll();
	}
	
	@Override
	public MajorTranslation saveAndReturnEntity(MajorTranslation obj) {
		save(obj);
		return obj;
	}
}
