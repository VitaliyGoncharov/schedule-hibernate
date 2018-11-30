package com.vitgon.schedulehib.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.vitgon.schedulehib.model.Locale;
import com.vitgon.schedulehib.repository.LocaleRepository;
import com.vitgon.schedulehib.repository.impl.base.BaseRepository;


public class LocaleRepositoryImpl extends BaseRepository<Locale, Integer> implements LocaleRepository {
	
	public LocaleRepositoryImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	public Locale findByCode(String code) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query<Locale> query = session.createQuery("from Locale where code = :code");
		query.setParameter("code", code);
		transaction.commit();
		return query.getSingleResult();
	}
	
}
