package com.vitgon.schedulehib.model.translation.pk;

import java.io.Serializable;
import java.util.Objects;

import com.vitgon.schedulehib.model.Locale;
import com.vitgon.schedulehib.model.Teacher;

public class TeacherTranslationId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5641639662460763411L;
	
	private Teacher teacher;
	private Locale locale;
	
	public TeacherTranslationId() {
	}

	public TeacherTranslationId(Teacher teacher, Locale locale) {
		this.teacher = teacher;
		this.locale = locale;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}

	public Locale getLocale() {
		return locale;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getTeacher(), getLocale());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof TeacherTranslationId)) return false;
		TeacherTranslationId that = (TeacherTranslationId) obj;
		return Objects.equals(getTeacher(), that.getTeacher()) &&
				Objects.equals(getLocale(), that.getLocale());
	}
}
