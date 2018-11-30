package com.vitgon.schedulehib.service.impl.translation;

import java.util.List;

import com.vitgon.schedulehib.model.translation.TeacherTranslation;
import com.vitgon.schedulehib.model.translation.pk.TeacherTranslationId;
import com.vitgon.schedulehib.repository.translation.TeacherTranslationRepository;
import com.vitgon.schedulehib.service.translation.TeacherTranslationService;

public class TeacherTranslationServiceImpl implements TeacherTranslationService {

	private final TeacherTranslationRepository teacherTranslRep;
	
	public TeacherTranslationServiceImpl(TeacherTranslationRepository teacherTranslRep) {
		this.teacherTranslRep = teacherTranslRep;
	}
	
	@Override
	public TeacherTranslationId save(TeacherTranslation obj) {
		return teacherTranslRep.save(obj);
	}

	@Override
	public void update(TeacherTranslation obj) {
		teacherTranslRep.update(obj);
	}

	@Override
	public TeacherTranslation findById(TeacherTranslationId id) {
		return teacherTranslRep.findById(id);
	}

	@Override
	public List<TeacherTranslation> findAll() {
		return teacherTranslRep.findAll();
	}
	
	@Override
	public TeacherTranslation saveAndReturnEntity(TeacherTranslation obj) {
		save(obj);
		return obj;
	}
}
