package com.vitgon.schedulehib;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vitgon.schedulehib.model.Group;
import com.vitgon.schedulehib.model.Locale;
import com.vitgon.schedulehib.model.Major;
import com.vitgon.schedulehib.model.Schedule;
import com.vitgon.schedulehib.model.School;
import com.vitgon.schedulehib.model.Subject;
import com.vitgon.schedulehib.model.Teacher;
import com.vitgon.schedulehib.model.translation.GroupTranslation;
import com.vitgon.schedulehib.model.translation.MajorTranslation;
import com.vitgon.schedulehib.model.translation.SchoolTranslation;
import com.vitgon.schedulehib.model.translation.SubjectTranslation;
import com.vitgon.schedulehib.model.translation.TeacherTranslation;
import com.vitgon.schedulehib.service.GroupService;
import com.vitgon.schedulehib.service.LocaleService;
import com.vitgon.schedulehib.service.MajorService;
import com.vitgon.schedulehib.service.ScheduleService;
import com.vitgon.schedulehib.service.SchoolService;
import com.vitgon.schedulehib.service.SubjectService;
import com.vitgon.schedulehib.service.TeacherService;
import com.vitgon.schedulehib.service.translation.GroupTranslationService;
import com.vitgon.schedulehib.service.translation.MajorTranslationService;
import com.vitgon.schedulehib.service.translation.SchoolTranslationService;
import com.vitgon.schedulehib.service.translation.SubjectTranslationService;
import com.vitgon.schedulehib.service.translation.TeacherTranslationService;
import com.vitgon.schedulehib.util.ServiceFactory;

/**
 * 
 * @author vitgon
 *
 */
public class Starter {
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	private SchoolService schoolService;
	private MajorService majorService;
	private GroupService groupService;
	private SubjectService subjectService;
	private ScheduleService scheduleService;
	private TeacherService teacherService;
	
	private SchoolTranslationService schoolTranslationService;
	private MajorTranslationService majorTranslationService;
	private GroupTranslationService groupTranslationService;
	private SubjectTranslationService subjectTranslationService;
	private TeacherTranslationService teacherTranslationService;
	
	private LocaleService localeService;
	
	
	public Starter() {
		schoolService = ServiceFactory.getRepository(SchoolService.class);
		majorService = ServiceFactory.getRepository(MajorService.class);
		groupService = ServiceFactory.getRepository(GroupService.class);
		subjectService = ServiceFactory.getRepository(SubjectService.class);
		scheduleService = ServiceFactory.getRepository(ScheduleService.class);
		teacherService = ServiceFactory.getRepository(TeacherService.class);
		
		schoolTranslationService = ServiceFactory.getRepository(SchoolTranslationService.class);
		majorTranslationService = ServiceFactory.getRepository(MajorTranslationService.class);
		groupTranslationService = ServiceFactory.getRepository(GroupTranslationService.class);
		subjectTranslationService = ServiceFactory.getRepository(SubjectTranslationService.class);
		teacherTranslationService = ServiceFactory.getRepository(TeacherTranslationService.class);
		
		localeService = ServiceFactory.getRepository(LocaleService.class);
	}

	public void start() {
		fillDB();
		
		// multi-language search
//		Major major = majorService.findByTitle("Economics security".toLowerCase());
		Major major = majorService.findByTitle("Экономическая безопасность".toLowerCase());

		try {
			String path = "src/main/resources/out.json";
			File file = new File(path);
			if (!file.exists()) file.createNewFile();
			
			// serialize object and place json in file | CTRL+SHIFT+F to format json
			String obj = objectMapper.writeValueAsString(major);
			Files.write(Paths.get(path), obj.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.exit(1);
	}
	
	@SuppressWarnings("unused")
	public void fillDB() {
		// create app locales
		Locale localeEnUS = localeService.saveAndReturnEntity(new Locale("english", "en_US"));
		Locale localeEnUK = localeService.saveAndReturnEntity(new Locale("english", "en_UK"));
		Locale localeRuRU = localeService.saveAndReturnEntity(new Locale("russian", "ru_RU"));

		// create school
		School school = schoolService.saveAndReturnEntity(new School("economics_and_management", null));

		// create school translations
		schoolTranslationService.save(new SchoolTranslation(school, localeRuRU, "школа экономики и менеджмента"));
		schoolTranslationService.save(new SchoolTranslation(school, localeEnUS, "school of economics and management"));

		// create majors for school
		Major economicsSecurity = majorService.saveAndReturnEntity(new Major("economics_security", 5, school));
		Major management = majorService.saveAndReturnEntity(new Major("management", 4, school));

		// create major translations
		majorTranslationService.save(new MajorTranslation(economicsSecurity, localeRuRU, "экономическая безопасность"));
		majorTranslationService.save(new MajorTranslation(economicsSecurity, localeEnUS, "economics security"));

		// create group and its translations
		Group groupS1401PD = groupService.saveAndReturnEntity(new Group(4, economicsSecurity, null));
		groupTranslationService.save(new GroupTranslation(groupS1401PD, localeRuRU, "с1401пд"));
		groupTranslationService.save(new GroupTranslation(groupS1401PD, localeEnUS, "s1401pd"));

		// create group and its translations
		Group groupS1401PE = groupService.saveAndReturnEntity(new Group(4, economicsSecurity, null));
		groupTranslationService.save(new GroupTranslation(groupS1401PE, localeRuRU, "с1401пе"));
		groupTranslationService.save(new GroupTranslation(groupS1401PE, localeEnUS, "s1401pe"));

		
		/* ******************************************************************* */
		
		// create teacher and his translation
		Teacher teacher = teacherService.saveAndReturnEntity(new Teacher("kremer.fn@dvfu.ru", null));
		TeacherTranslation teacherTransl = new TeacherTranslation();
		teacherTransl.setTeacher(teacher);
		teacherTransl.setLocale(localeRuRU);
		teacherTransl.setLastname("Кремер");
		teacherTransl.setFirstname("Федор");
		teacherTransl.setMiddlename("Николаевич");
		teacherTranslationService.save(teacherTransl);
		
		// create subject and its translations
		Subject criminalProcess = subjectService.saveAndReturnEntity(new Subject());
		subjectTranslationService.save(new SubjectTranslation(criminalProcess, localeRuRU, "уголовный процесс"));
		subjectTranslationService.save(new SubjectTranslation(criminalProcess, localeEnUS, "criminal process"));
		
		// create schedule
		Schedule schedule = new Schedule();
		schedule.setSubject(criminalProcess);
		schedule.setDayNum(1);
		schedule.setWeek(1);
		schedule.setSubjectNum(5);
		schedule.setGroup(groupS1401PD);
		schedule.setLessonType(1);
		schedule.setClassroom("G237");
		schedule.setTeacher(teacher);
		scheduleService.save(schedule);
	}
	
	public static void main(String[] args) {
		(new Starter()).start();
	}
}