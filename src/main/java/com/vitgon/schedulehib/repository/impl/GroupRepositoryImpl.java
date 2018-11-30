package com.vitgon.schedulehib.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;

import com.vitgon.schedulehib.model.Group;
import com.vitgon.schedulehib.repository.GroupRepository;
import com.vitgon.schedulehib.repository.impl.base.BaseRepository;

public class GroupRepositoryImpl extends BaseRepository<Group, Integer> implements GroupRepository {
	
	public GroupRepositoryImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public Group findByTitle(String title) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Group.class, "group");
		criteria.createAlias("group.groupTranslations", "groupTranslation");
		criteria.add(Restrictions.eq("groupTranslation.title", title));
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		Group group = (Group) criteria.uniqueResult();
		transaction.commit();
		session.close();
		return group;
	}
}
