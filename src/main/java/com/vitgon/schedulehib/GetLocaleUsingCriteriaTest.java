package com.vitgon.schedulehib;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Restrictions;

import com.vitgon.schedulehib.model.Locale;

public class GetLocaleUsingCriteriaTest {

	private static final SessionFactory sessionFactory;

	static {
		try {
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
					.configure("hibernate.cfg.xml").build();
			Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
			sessionFactory = metaData.getSessionFactoryBuilder().build();
		} catch (Throwable th) {
			System.err.println("Enitial SessionFactory creation failed" + th);
			throw new ExceptionInInitializerError(th);
		}
	}

	public static Session getSession() throws HibernateException {
		return sessionFactory.openSession();
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		final Session session = getSession();
		try {
			Criteria criteria = session.createCriteria(Locale.class).add(Restrictions.eq("id", new Integer(1)));

			// Convenience method to return a single instance that matches the
			// query, or null if the query returns no results.
			Object result = criteria.uniqueResult();
			if (result != null) {
				Locale locale = (Locale) result;
				System.out.println(locale);
			}
		} finally {
			session.close();
			System.exit(1);
		}
	}

}
