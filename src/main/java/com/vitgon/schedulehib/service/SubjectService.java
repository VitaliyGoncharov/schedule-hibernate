package com.vitgon.schedulehib.service;

import com.vitgon.schedulehib.model.Subject;
import com.vitgon.schedulehib.service.base.Service;

public interface SubjectService extends Service<Subject, Integer> {
	Subject findByTitle(String title);
	Subject saveAndReturnEntity(Subject obj);
}
