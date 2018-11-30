package com.vitgon.schedulehib.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;

import com.vitgon.schedulehib.model.Subject;
import com.vitgon.schedulehib.repository.SubjectRepository;
import com.vitgon.schedulehib.repository.impl.base.BaseRepository;

public class SubjectRepositoryImpl extends BaseRepository<Subject, Integer> implements SubjectRepository {
	
	public SubjectRepositoryImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public Subject findByTitle(String title) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Subject.class, "subject");
		criteria.createAlias("subject.subjectTranslations", "subjectTranslations");
		criteria.add(Restrictions.eq("subjectTranslations.title", title));
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		Subject subject = (Subject) criteria.uniqueResult();
		transaction.commit();
		return subject;
	}
}
