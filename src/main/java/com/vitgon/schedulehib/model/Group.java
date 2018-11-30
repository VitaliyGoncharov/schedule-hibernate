package com.vitgon.schedulehib.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vitgon.schedulehib.model.translation.GroupTranslation;

@Entity
@Table(name = "groups")
public class Group extends BaseModel<Integer> {
	
	@Column(name = "course_num")
	private int courseNum;
	
	@JsonIgnore
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	private Major major;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
	private List<GroupTranslation> groupTranslations = new ArrayList<>();
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "group")
	private List<Schedule> schedules = new ArrayList<>();

	public Group() {
	}

	public Group(int courseNum, Major major, List<GroupTranslation> groupTranslations) {
		this.courseNum = courseNum;
		this.major = major;
		this.groupTranslations = groupTranslations;
	}

	public int getCourseNum() {
		return courseNum;
	}

	public void setCourseNum(int courseNum) {
		this.courseNum = courseNum;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public List<GroupTranslation> getGroupTranslations() {
		return groupTranslations;
	}

	public void setGroupTranslations(List<GroupTranslation> groupTranslations) {
		this.groupTranslations = groupTranslations;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}
}
