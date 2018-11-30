package com.vitgon.schedulehib.service.translation;

import com.vitgon.schedulehib.model.translation.TeacherTranslation;
import com.vitgon.schedulehib.model.translation.pk.TeacherTranslationId;
import com.vitgon.schedulehib.service.base.Service;

public interface TeacherTranslationService extends Service<TeacherTranslation, TeacherTranslationId>{
	TeacherTranslation saveAndReturnEntity(TeacherTranslation obj);
}
