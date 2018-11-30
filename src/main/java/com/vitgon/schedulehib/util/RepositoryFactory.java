package com.vitgon.schedulehib.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.vitgon.schedulehib.repository.GroupRepository;
import com.vitgon.schedulehib.repository.LocaleRepository;
import com.vitgon.schedulehib.repository.MajorRepository;
import com.vitgon.schedulehib.repository.ScheduleRepository;
import com.vitgon.schedulehib.repository.SchoolRepository;
import com.vitgon.schedulehib.repository.SubjectRepository;
import com.vitgon.schedulehib.repository.TeacherRepository;
import com.vitgon.schedulehib.repository.base.Repository;
import com.vitgon.schedulehib.repository.impl.GroupRepositoryImpl;
import com.vitgon.schedulehib.repository.impl.LocaleRepositoryImpl;
import com.vitgon.schedulehib.repository.impl.MajorRepositoryImpl;
import com.vitgon.schedulehib.repository.impl.ScheduleRepositoryImpl;
import com.vitgon.schedulehib.repository.impl.SchoolRepositoryImpl;
import com.vitgon.schedulehib.repository.impl.SubjectRepositoryImpl;
import com.vitgon.schedulehib.repository.impl.TeacherRepositoryImpl;
import com.vitgon.schedulehib.repository.impl.translation.GroupTranslationRepositoryImpl;
import com.vitgon.schedulehib.repository.impl.translation.MajorTranslationRepositoryImpl;
import com.vitgon.schedulehib.repository.impl.translation.SchoolTranslationRepositoryImpl;
import com.vitgon.schedulehib.repository.impl.translation.SubjectTranslationRepositoryImpl;
import com.vitgon.schedulehib.repository.impl.translation.TeacherTranslationRepositoryImpl;
import com.vitgon.schedulehib.repository.translation.GroupTranslationRepository;
import com.vitgon.schedulehib.repository.translation.MajorTranslationRepository;
import com.vitgon.schedulehib.repository.translation.SchoolTranslationRepository;
import com.vitgon.schedulehib.repository.translation.SubjectTranslationRepository;
import com.vitgon.schedulehib.repository.translation.TeacherTranslationRepository;

public class RepositoryFactory {
	
	private static Map<Class<?>, Class<?>> repositories = new HashMap<>();
	
	private RepositoryFactory() {}
	
	static {
		repositories.put(GroupRepository.class, GroupRepositoryImpl.class);
		repositories.put(LocaleRepository.class, LocaleRepositoryImpl.class);
		repositories.put(MajorRepository.class, MajorRepositoryImpl.class);
		repositories.put(ScheduleRepository.class, ScheduleRepositoryImpl.class);
		repositories.put(SchoolRepository.class, SchoolRepositoryImpl.class);
		repositories.put(SubjectRepository.class, SubjectRepositoryImpl.class);
		repositories.put(TeacherRepository.class, TeacherRepositoryImpl.class);
		
		repositories.put(GroupTranslationRepository.class, GroupTranslationRepositoryImpl.class);
		repositories.put(MajorTranslationRepository.class, MajorTranslationRepositoryImpl.class);
		repositories.put(SchoolTranslationRepository.class, SchoolTranslationRepositoryImpl.class);
		repositories.put(SubjectTranslationRepository.class, SubjectTranslationRepositoryImpl.class);
		repositories.put(TeacherTranslationRepository.class, TeacherTranslationRepositoryImpl.class);
	}
	
	@SuppressWarnings({"unchecked","rawtypes"})
	public static <T extends Repository> T getRepository(Class<T> clazz) {
		
		try {
			Class repositoryImpl = repositories.get(clazz);
			Constructor constructor = repositoryImpl.getConstructor(SessionFactory.class);
			return (T) constructor.newInstance(HibernateUtil.getSessionFactory());
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
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
