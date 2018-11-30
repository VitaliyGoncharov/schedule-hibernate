package com.vitgon.schedulehib.model.translation.pk;

import java.io.Serializable;
import java.util.Objects;

import com.vitgon.schedulehib.model.Locale;
import com.vitgon.schedulehib.model.Subject;

public class SubjectTranslationId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7802327655330293030L;
	
	private Subject subject;
	private Locale locale;
	
	public SubjectTranslationId() {
	}
	
	public SubjectTranslationId(Subject subject, Locale locale) {
		this.subject = subject;
		this.locale = locale;
	}
	
	public Subject getSubject() {
		return subject;
	}
	public Locale getLocale() {
		return locale;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getSubject(), getLocale());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof SubjectTranslationId)) return false;
		SubjectTranslationId that = (SubjectTranslationId) obj;
		return Objects.equals(getSubject(), that.getSubject()) &&
				Objects.equals(getLocale(), that.getLocale());
	}
}
