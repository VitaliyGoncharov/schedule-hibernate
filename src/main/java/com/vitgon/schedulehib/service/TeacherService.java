package com.vitgon.schedulehib.service;

import com.vitgon.schedulehib.model.Teacher;
import com.vitgon.schedulehib.service.base.Service;

public interface TeacherService extends Service<Teacher, Integer> {
	Teacher saveAndReturnEntity(Teacher obj);
}
