package com.vitgon.schedulehib.model.translation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vitgon.schedulehib.model.Locale;
import com.vitgon.schedulehib.model.Subject;
import com.vitgon.schedulehib.model.translation.pk.SubjectTranslationId;

@Entity
@Table(name = "subject_translations")
@IdClass(SubjectTranslationId.class)
public class SubjectTranslation {
	
	@Id
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "locale_id")
	private Locale locale;
	
	@Column(name = "title")
	private String title;
	
	public SubjectTranslation() {
	}

	public SubjectTranslation(Subject subject, Locale locale, String title) {
		super();
		this.subject = subject;
		this.locale = locale;
		this.title = title;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
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
