package com.vitgon.schedulehib.repository;

import com.vitgon.schedulehib.model.Subject;
import com.vitgon.schedulehib.repository.base.Repository;

public interface SubjectRepository extends Repository<Subject, Integer> {
	Subject findByTitle(String title);
}
