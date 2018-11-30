package com.vitgon.schedulehib.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.vitgon.schedulehib.model.translation.GroupTranslation;
import com.vitgon.schedulehib.model.translation.MajorTranslation;
import com.vitgon.schedulehib.model.translation.SchoolTranslation;
import com.vitgon.schedulehib.model.translation.SubjectTranslation;
import com.vitgon.schedulehib.model.translation.TeacherTranslation;

@Entity
@Table(name = "locales")
public class Locale extends BaseModel<Integer> {
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "code")
	private String code;
	
	@JsonBackReference
	@OneToMany(mappedBy = "locale")
	private List<MajorTranslation> majorTranslations = new ArrayList<>();
	
	@JsonBackReference
	@OneToMany(mappedBy = "locale")
	private List<SchoolTranslation> schoolTranslations = new ArrayList<>();
	
	@JsonBackReference
	@OneToMany(mappedBy = "locale")
	private List<SubjectTranslation> subjectTranslations = new ArrayList<>();
	
	@JsonBackReference
	@OneToMany(mappedBy = "locale")
	private List<GroupTranslation> groupTranslations = new ArrayList<>();
	
	@JsonBackReference
	@OneToMany(mappedBy = "locale")
	private List<TeacherTranslation> teacherTranslations = new ArrayList<>();

	public Locale() {
	}

	public Locale(String name, String code) {
		super();
		this.name = name;
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<MajorTranslation> getMajorTranslations() {
		return majorTranslations;
	}

	public void setMajorTranslations(List<MajorTranslation> majorTranslations) {
		this.majorTranslations = majorTranslations;
	}

	public List<SchoolTranslation> getSchoolTranslations() {
		return schoolTranslations;
	}

	public void setSchoolTranslations(List<SchoolTranslation> schoolTranslations) {
		this.schoolTranslations = schoolTranslations;
	}

	public List<SubjectTranslation> getSubjectTranslations() {
		return subjectTranslations;
	}

	public void setSubjectTranslations(List<SubjectTranslation> subjectTranslations) {
		this.subjectTranslations = subjectTranslations;
	}

	public List<GroupTranslation> getGroupTranslations() {
		return groupTranslations;
	}

	public void setGroupTranslations(List<GroupTranslation> groupTranslations) {
		this.groupTranslations = groupTranslations;
	}

	public List<TeacherTranslation> getTeacherTranslations() {
		return teacherTranslations;
	}

	public void setTeacherTranslations(List<TeacherTranslation> teacherTranslations) {
		this.teacherTranslations = teacherTranslations;
	}

	@Override
	public String toString() {
		return "Locale [name=" + name + ", code=" + code + "]";
	}
}
