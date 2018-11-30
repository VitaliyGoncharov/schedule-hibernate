package com.vitgon.schedulehib.service;

import com.vitgon.schedulehib.model.Group;
import com.vitgon.schedulehib.service.base.Service;

public interface GroupService extends Service<Group, Integer> {
	Group findByTitle(String title);
	Group saveAndReturnEntity(Group obj);
}
