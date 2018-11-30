package com.vitgon.schedulehib.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;

import com.vitgon.schedulehib.model.Major;
import com.vitgon.schedulehib.repository.MajorRepository;
import com.vitgon.schedulehib.repository.impl.base.BaseRepository;

public class MajorRepositoryImpl extends BaseRepository<Major, Integer> implements MajorRepository {
	
	public MajorRepositoryImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public Major findByTitle(String title) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Major.class, "major");
		criteria.createAlias("major.majorTranslations", "majorTranslations");
		criteria.add(Restrictions.eq("majorTranslations.title", title));
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		Major major = (Major) criteria.uniqueResult();
		transaction.commit();
		return major;
	}
}
