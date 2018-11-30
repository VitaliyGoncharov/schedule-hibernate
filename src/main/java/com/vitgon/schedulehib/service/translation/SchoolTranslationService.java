package com.vitgon.schedulehib.service.translation;

import com.vitgon.schedulehib.model.translation.SchoolTranslation;
import com.vitgon.schedulehib.model.translation.pk.SchoolTranslationId;
import com.vitgon.schedulehib.service.base.Service;

public interface SchoolTranslationService extends Service<SchoolTranslation, SchoolTranslationId> {
	SchoolTranslation saveAndReturnEntity(SchoolTranslation obj);
}
