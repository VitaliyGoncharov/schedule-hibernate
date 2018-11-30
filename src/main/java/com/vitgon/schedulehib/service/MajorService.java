package com.vitgon.schedulehib.service;

import com.vitgon.schedulehib.model.Major;
import com.vitgon.schedulehib.service.base.Service;

public interface MajorService extends Service<Major, Integer>{
	Major findByTitle(String title);
	Major saveAndReturnEntity(Major obj);
}
