package com.vitgon.schedulehib.repository.impl.translation;

import org.hibernate.SessionFactory;

import com.vitgon.schedulehib.model.translation.MajorTranslation;
import com.vitgon.schedulehib.model.translation.pk.MajorTranslationId;
import com.vitgon.schedulehib.repository.impl.base.BaseRepository;
import com.vitgon.schedulehib.repository.translation.MajorTranslationRepository;

public class MajorTranslationRepositoryImpl extends BaseRepository<MajorTranslation, MajorTranslationId> 
	implements MajorTranslationRepository {
	
	public MajorTranslationRepositoryImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
