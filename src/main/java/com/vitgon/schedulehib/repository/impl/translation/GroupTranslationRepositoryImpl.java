package com.vitgon.schedulehib.repository.impl.translation;

import org.hibernate.SessionFactory;

import com.vitgon.schedulehib.model.translation.GroupTranslation;
import com.vitgon.schedulehib.model.translation.pk.GroupTranslationId;
import com.vitgon.schedulehib.repository.impl.base.BaseRepository;
import com.vitgon.schedulehib.repository.translation.GroupTranslationRepository;

public class GroupTranslationRepositoryImpl extends BaseRepository<GroupTranslation, GroupTranslationId>
	implements GroupTranslationRepository {
	
	public GroupTranslationRepositoryImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
