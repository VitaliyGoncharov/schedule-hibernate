package com.vitgon.schedulehib.repository.impl.translation;

import org.hibernate.SessionFactory;

import com.vitgon.schedulehib.model.translation.SchoolTranslation;
import com.vitgon.schedulehib.model.translation.pk.SchoolTranslationId;
import com.vitgon.schedulehib.repository.impl.base.BaseRepository;
import com.vitgon.schedulehib.repository.translation.SchoolTranslationRepository;

public class SchoolTranslationRepositoryImpl extends BaseRepository<SchoolTranslation, SchoolTranslationId> 
	implements SchoolTranslationRepository {
	
	public SchoolTranslationRepositoryImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
