package com.vitgon.schedulehib.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vitgon.schedulehib.model.translation.TeacherTranslation;

@Entity
@Table(name = "teacher")
public class Teacher extends BaseModel<Integer> {
	
	@Column(name = "mail")
	private String mail;
	
	@JsonIgnore
	@OneToMany(mappedBy = "teacher")
	private List<Schedule> shedules = new ArrayList<>();
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "teacher")
	private List<TeacherTranslation> teacherTranslations = new ArrayList<>();
	
	public Teacher() {
	}

	public Teacher(String mail, List<Schedule> shedules) {
		this.mail = mail;
		this.shedules = shedules;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public List<Schedule> getShedules() {
		return shedules;
	}

	public void setShedules(List<Schedule> shedules) {
		this.shedules = shedules;
	}

	public List<TeacherTranslation> getTeacherTranslations() {
		return teacherTranslations;
	}

	public void setTeacherTranslations(List<TeacherTranslation> teacherTranslations) {
		this.teacherTranslations = teacherTranslations;
	}
}
