package com.vitgon.schedulehib.service.translation;

import com.vitgon.schedulehib.model.translation.MajorTranslation;
import com.vitgon.schedulehib.model.translation.pk.MajorTranslationId;
import com.vitgon.schedulehib.service.base.Service;

public interface MajorTranslationService extends Service<MajorTranslation, MajorTranslationId> {
	MajorTranslation saveAndReturnEntity(MajorTranslation obj);
}
