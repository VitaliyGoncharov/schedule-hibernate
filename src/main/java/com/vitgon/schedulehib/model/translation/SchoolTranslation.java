package com.vitgon.schedulehib.model.translation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.vitgon.schedulehib.model.Locale;
import com.vitgon.schedulehib.model.School;
import com.vitgon.schedulehib.model.translation.pk.SchoolTranslationId;

@Entity
@Table(name = "school_translations")
@IdClass(SchoolTranslationId.class)
public class SchoolTranslation {
	
	@Id
	@ManyToOne
	@JoinColumn(name = "school_id")
	@JsonBackReference
	private School school;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "locale_id")
	private Locale locale;
	
	@Column(name = "title")
	private String title;
	

	public SchoolTranslation() {
	}

	public SchoolTranslation(School school, Locale locale, String title) {
		super();
		this.school = school;
		this.locale = locale;
		this.title = title;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
