package com.vitgon.schedulehib.model.translation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.vitgon.schedulehib.model.Group;
import com.vitgon.schedulehib.model.Locale;
import com.vitgon.schedulehib.model.translation.pk.GroupTranslationId;

@Entity
@Table(name = "group_translations")
@IdClass(GroupTranslationId.class)
public class GroupTranslation {
	
	@Id
	@ManyToOne
	@JoinColumn(name = "group_id")
	@JsonBackReference
	private Group group;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "locale_id")
	private Locale locale;
	
	@Column(name = "title")
	private String title;
	
	public GroupTranslation() {
	}

	public GroupTranslation(Group group, Locale locale, String title) {
		this.group = group;
		this.locale = locale;
		this.title = title;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
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
