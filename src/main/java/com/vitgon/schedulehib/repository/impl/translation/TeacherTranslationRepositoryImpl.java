package com.vitgon.schedulehib.repository.impl.translation;

import org.hibernate.SessionFactory;

import com.vitgon.schedulehib.model.translation.TeacherTranslation;
import com.vitgon.schedulehib.model.translation.pk.TeacherTranslationId;
import com.vitgon.schedulehib.repository.impl.base.BaseRepository;
import com.vitgon.schedulehib.repository.translation.TeacherTranslationRepository;

public class TeacherTranslationRepositoryImpl extends BaseRepository<TeacherTranslation, TeacherTranslationId> 
	implements TeacherTranslationRepository {

	public TeacherTranslationRepositoryImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
