package com.vitgon.schedulehib.service.translation;

import com.vitgon.schedulehib.model.translation.SubjectTranslation;
import com.vitgon.schedulehib.model.translation.pk.SubjectTranslationId;
import com.vitgon.schedulehib.service.base.Service;

public interface SubjectTranslationService extends Service<SubjectTranslation, SubjectTranslationId> {
	SubjectTranslation saveAndReturnEntity(SubjectTranslation obj);
}
