package com.vitgon.schedulehib.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vitgon.schedulehib.model.translation.SubjectTranslation;

@Entity
@Table(name = "subjects")
public class Subject extends BaseModel<Integer> {
	
	@JsonIgnore
	@OneToMany(mappedBy = "subject")
	private List<Schedule> schedules = new ArrayList<>();
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "subject")
	private List<SubjectTranslation> subjectTranslations = new ArrayList<>();
	
	public Subject() {
	}

	public Subject(List<Schedule> schedules, List<SubjectTranslation> subjectTranslations) {
		super();
		this.schedules = schedules;
		this.subjectTranslations = subjectTranslations;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	public List<SubjectTranslation> getSubjectTranslations() {
		return subjectTranslations;
	}

	public void setSubjectTranslations(List<SubjectTranslation> subjectTranslations) {
		this.subjectTranslations = subjectTranslations;
	}
}
