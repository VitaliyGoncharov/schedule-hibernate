package com.vitgon.schedulehib;

import com.vitgon.schedulehib.model.School;
import com.vitgon.schedulehib.service.SchoolService;
import com.vitgon.schedulehib.util.ServiceFactory;

public class FactoryTest {
	
	private SchoolService schoolService;
	
	public FactoryTest() {
		schoolService = ServiceFactory.getRepository(SchoolService.class);
	}
	
	public void start() {
		School school = schoolService.findByTitle("Экономическая безопасность");
		System.out.println(school);
	}

	public static void main(String[] args) {
		(new FactoryTest()).start();
		System.exit(1);
	}

}
