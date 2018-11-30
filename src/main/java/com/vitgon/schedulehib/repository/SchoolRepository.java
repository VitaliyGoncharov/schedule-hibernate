package com.vitgon.schedulehib.repository;

import com.vitgon.schedulehib.model.School;
import com.vitgon.schedulehib.repository.base.Repository;

public interface SchoolRepository extends Repository<School, Integer> {
	
	School findByTitle(String title);
}
