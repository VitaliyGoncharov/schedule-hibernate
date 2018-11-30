package com.vitgon.schedulehib.repository;

import com.vitgon.schedulehib.model.Locale;
import com.vitgon.schedulehib.repository.base.Repository;


public interface LocaleRepository extends Repository<Locale, Integer> {
	Locale findByCode(String code);
}
