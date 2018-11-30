package com.vitgon.schedulehib.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.vitgon.schedulehib.model.School;
import com.vitgon.schedulehib.repository.SchoolRepository;
import com.vitgon.schedulehib.service.SchoolService;

public class SchoolServiceTest {

	@Test
	public void createSchool() {
		SchoolRepository schoolRep = mock(SchoolRepository.class);
		SchoolService schoolService = new SchoolServiceImpl(schoolRep);
		School school = new School();
		when(schoolRep.save(school)).thenReturn(1);
		assertEquals(new Integer(1), schoolService.save(school));
	}
}
