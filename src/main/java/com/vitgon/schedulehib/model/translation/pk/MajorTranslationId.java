package com.vitgon.schedulehib.model.translation.pk;

import java.io.Serializable;
import java.util.Objects;

import com.vitgon.schedulehib.model.Locale;
import com.vitgon.schedulehib.model.Major;


public class MajorTranslationId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4322466337734164549L;

	private Major major;
	private Locale locale;
	
	public MajorTranslationId() {
	}

	public MajorTranslationId(Major major, Locale locale) {
		super();
		this.major = major;
		this.locale = locale;
	}

	public Major getMajor() {
		return major;
	}

	public Locale getLocale() {
		return locale;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getMajor(), getLocale());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof MajorTranslationId)) return false;
		MajorTranslationId that = (MajorTranslationId) obj;
		return Objects.equals(getMajor(), that.getMajor()) &&
				Objects.equals(getLocale(), that.getLocale());
	}
}
