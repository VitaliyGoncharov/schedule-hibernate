package com.vitgon.schedulehib.repository.impl.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.vitgon.schedulehib.repository.base.Repository;

public abstract class BaseRepository<T, K> implements Repository<T, K> {
	
	protected SessionFactory sessionFactory;
	private Class<T> entityBeanType;
	
	@SuppressWarnings("unchecked")
	public BaseRepository(SessionFactory sessionFactory) {
		this.entityBeanType = ((Class<T>) ((ParameterizedType) getClass()
		        .getGenericSuperclass()).getActualTypeArguments()[0]);
		this.sessionFactory = sessionFactory;
	}
	
	public Class<T> getEntityBeanType() {
		return entityBeanType;
	}

	@Override
	public T findById(K id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		T result = session.find(getEntityBeanType(), id);
		transaction.commit();
		session.close();
		return result;
	}
	
	@Override
	public List<T> findAll() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		TypedQuery<T> query = session.createQuery("from " + getEntityBeanType().getName());
		List<T> resultList = query.getResultList();
		transaction.commit();
		session.close();
		return resultList;
	}

	@Override
	@SuppressWarnings("unchecked")
	public K save(T obj) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		K id = (K) session.save(obj);
		transaction.commit();
		session.close();
		return id;
	}

	@Override
	public void update(T obj) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(obj);
		session.getTransaction().commit();
		session.close();
	}
}
