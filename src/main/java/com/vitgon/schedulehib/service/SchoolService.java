package com.vitgon.schedulehib.service;

import com.vitgon.schedulehib.model.School;
import com.vitgon.schedulehib.service.base.Service;

public interface SchoolService extends Service<School, Integer> {
	School findByTitle(String title);
	School saveAndReturnEntity(School obj);
}
