package com.vitgon.schedulehib.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import com.vitgon.schedulehib.service.GroupService;
import com.vitgon.schedulehib.service.LocaleService;
import com.vitgon.schedulehib.service.MajorService;
import com.vitgon.schedulehib.service.ScheduleService;
import com.vitgon.schedulehib.service.SchoolService;
import com.vitgon.schedulehib.service.SubjectService;
import com.vitgon.schedulehib.service.TeacherService;
import com.vitgon.schedulehib.service.base.Service;
import com.vitgon.schedulehib.service.impl.GroupServiceImpl;
import com.vitgon.schedulehib.service.impl.LocaleServiceImpl;
import com.vitgon.schedulehib.service.impl.MajorServiceImpl;
import com.vitgon.schedulehib.service.impl.ScheduleServiceImpl;
import com.vitgon.schedulehib.service.impl.SchoolServiceImpl;
import com.vitgon.schedulehib.service.impl.SubjectServiceImpl;
import com.vitgon.schedulehib.service.impl.TeacherServiceImpl;
import com.vitgon.schedulehib.service.impl.translation.GroupTranslationServiceImpl;
import com.vitgon.schedulehib.service.impl.translation.MajorTranslationServiceImpl;
import com.vitgon.schedulehib.service.impl.translation.SchoolTranslationServiceImpl;
import com.vitgon.schedulehib.service.impl.translation.SubjectTranslationServiceImpl;
import com.vitgon.schedulehib.service.impl.translation.TeacherTranslationServiceImpl;
import com.vitgon.schedulehib.service.translation.GroupTranslationService;
import com.vitgon.schedulehib.service.translation.MajorTranslationService;
import com.vitgon.schedulehib.service.translation.SchoolTranslationService;
import com.vitgon.schedulehib.service.translation.SubjectTranslationService;
import com.vitgon.schedulehib.service.translation.TeacherTranslationService;

public class ServiceFactory {
	private static Map<Class<?>, Class<?>> repositories = new HashMap<>();
	
	static {
		repositories.put(GroupService.class, GroupServiceImpl.class);
		repositories.put(LocaleService.class, LocaleServiceImpl.class);
		repositories.put(MajorService.class, MajorServiceImpl.class);
		repositories.put(ScheduleService.class, ScheduleServiceImpl.class);
		repositories.put(SchoolService.class, SchoolServiceImpl.class);
		repositories.put(SubjectService.class, SubjectServiceImpl.class);
		repositories.put(TeacherService.class, TeacherServiceImpl.class);
		
		repositories.put(GroupTranslationService.class, GroupTranslationServiceImpl.class);
		repositories.put(MajorTranslationService.class, MajorTranslationServiceImpl.class);
		repositories.put(SchoolTranslationService.class, SchoolTranslationServiceImpl.class);
		repositories.put(SubjectTranslationService.class, SubjectTranslationServiceImpl.class);
		repositories.put(TeacherTranslationService.class, TeacherTranslationServiceImpl.class);
	}
	
	@SuppressWarnings({"unchecked","rawtypes"})
	public static <T extends Service> T getRepository(Class<T> clazz) {
		try {
			Class<?> serviceImpl = repositories.get(clazz);
			Constructor constructor = serviceImpl.getConstructors()[0];
			Class paramType = constructor.getParameterTypes()[0];
			System.out.println("Create dependency of type: " + paramType.getCanonicalName());
			return (T) constructor.newInstance(RepositoryFactory.getRepository(paramType));
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
