package com.vitgon.schedulehib.service;

import com.vitgon.schedulehib.model.Locale;
import com.vitgon.schedulehib.service.base.Service;


public interface LocaleService extends Service<Locale, Integer> {
	Locale findByCode(String code);
	Locale saveAndReturnEntity(Locale obj);
}
