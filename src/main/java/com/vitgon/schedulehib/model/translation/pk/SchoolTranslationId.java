package com.vitgon.schedulehib.model.translation.pk;

import java.io.Serializable;
import java.util.Objects;

import com.vitgon.schedulehib.model.Locale;
import com.vitgon.schedulehib.model.School;

public class SchoolTranslationId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7284414585673531241L;

	private School school;
	private Locale locale;
	
	public SchoolTranslationId() {
	}
	
	public SchoolTranslationId(School school, Locale locale) {
		super();
		this.school = school;
		this.locale = locale;
	}

	public School getSchool() {
		return school;
	}
	public Locale getLocale() {
		return locale;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getSchool(), getLocale());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof SchoolTranslationId)) return false;
		SchoolTranslationId that = (SchoolTranslationId) obj;
		return Objects.equals(getSchool(), that.getSchool()) &&
				Objects.equals(getLocale(), that.getLocale());
	}
}
