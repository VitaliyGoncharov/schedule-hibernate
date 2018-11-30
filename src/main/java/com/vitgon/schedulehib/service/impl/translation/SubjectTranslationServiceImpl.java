package com.vitgon.schedulehib.service.impl.translation;

import java.util.List;

import com.vitgon.schedulehib.model.translation.SubjectTranslation;
import com.vitgon.schedulehib.model.translation.pk.SubjectTranslationId;
import com.vitgon.schedulehib.repository.translation.SubjectTranslationRepository;
import com.vitgon.schedulehib.service.translation.SubjectTranslationService;

public class SubjectTranslationServiceImpl implements SubjectTranslationService {

	private final SubjectTranslationRepository subjectTranslRep;
	
	public SubjectTranslationServiceImpl(SubjectTranslationRepository subjectTranslRep) {
		this.subjectTranslRep = subjectTranslRep;
	}
	
	@Override
	public SubjectTranslationId save(SubjectTranslation obj) {
		return subjectTranslRep.save(obj);
	}

	@Override
	public void update(SubjectTranslation obj) {
		subjectTranslRep.update(obj);
	}

	@Override
	public SubjectTranslation findById(SubjectTranslationId id) {
		return subjectTranslRep.findById(id);
	}

	@Override
	public List<SubjectTranslation> findAll() {
		return subjectTranslRep.findAll();
	}
	
	@Override
	public SubjectTranslation saveAndReturnEntity(SubjectTranslation obj) {
		save(obj);
		return obj;
	}
}
