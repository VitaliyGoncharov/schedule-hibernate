package com.vitgon.schedulehib.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;

import com.vitgon.schedulehib.model.School;
import com.vitgon.schedulehib.repository.SchoolRepository;
import com.vitgon.schedulehib.repository.impl.base.BaseRepository;

public class SchoolRepositoryImpl extends BaseRepository<School, Integer> implements SchoolRepository {
	
	public SchoolRepositoryImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public School findByTitle(String title) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(School.class, "school");
		criteria.createAlias("school.schoolTranslations", "schoolTranslations");
		criteria.add(Restrictions.eq("schoolTranslations.title", title));
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		School school = (School) criteria.uniqueResult();
		transaction.commit();
		return school;
	}
}
