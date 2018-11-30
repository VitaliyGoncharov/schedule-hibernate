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
import com.vitgon.schedulehib.model.Major;
import com.vitgon.schedulehib.model.translation.pk.MajorTranslationId;


@Entity
@Table(name = "major_translations")
@IdClass(MajorTranslationId.class)
public class MajorTranslation {
	
	@Id
	@ManyToOne
	@JoinColumn(name = "major_id")
	@JsonBackReference
	private Major major;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "locale_id")
	private Locale locale;
	
	@Column(name = "title")
	private String title;

	public MajorTranslation() {
	}

	public MajorTranslation(Major major, Locale locale, String title) {
		super();
		this.major = major;
		this.locale = locale;
		this.title = title;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
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
