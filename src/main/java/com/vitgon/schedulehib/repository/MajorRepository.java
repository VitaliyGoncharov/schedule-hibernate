package com.vitgon.schedulehib.repository;

import com.vitgon.schedulehib.model.Major;
import com.vitgon.schedulehib.repository.base.Repository;

public interface MajorRepository extends Repository<Major, Integer>{
	Major findByTitle(String title);
}
