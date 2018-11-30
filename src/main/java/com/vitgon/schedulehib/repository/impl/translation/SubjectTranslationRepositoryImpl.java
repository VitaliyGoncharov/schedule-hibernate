package com.vitgon.schedulehib.repository.impl.translation;

import org.hibernate.SessionFactory;

import com.vitgon.schedulehib.model.translation.SubjectTranslation;
import com.vitgon.schedulehib.model.translation.pk.SubjectTranslationId;
import com.vitgon.schedulehib.repository.impl.base.BaseRepository;
import com.vitgon.schedulehib.repository.translation.SubjectTranslationRepository;

public class SubjectTranslationRepositoryImpl extends BaseRepository<SubjectTranslation, SubjectTranslationId> 
	implements SubjectTranslationRepository {
	
	public SubjectTranslationRepositoryImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
