package com.vitgon.schedulehib.service.translation;

import com.vitgon.schedulehib.model.translation.GroupTranslation;
import com.vitgon.schedulehib.model.translation.pk.GroupTranslationId;
import com.vitgon.schedulehib.service.base.Service;

public interface GroupTranslationService extends Service<GroupTranslation, GroupTranslationId> {
	GroupTranslation saveAndReturnEntity(GroupTranslation obj);
}
