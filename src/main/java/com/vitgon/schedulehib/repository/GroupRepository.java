package com.vitgon.schedulehib.repository;

import com.vitgon.schedulehib.model.Group;
import com.vitgon.schedulehib.repository.base.Repository;

public interface GroupRepository extends Repository<Group, Integer> {
	Group findByTitle(String title);
}
