package com.vitgon.schedulehib.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.vitgon.schedulehib.model.translation.MajorTranslation;

@Entity
@Table(name = "major")
public class Major extends BaseModel<Integer> {
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "duration")
	private int duration;
	
	@JsonBackReference
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "school_id")
	private School school;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "major")
	private List<Group> groups = new ArrayList<>();
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "major")
	private List<MajorTranslation> majorTranslations = new ArrayList<>();

	public Major() {
	}

	public Major(String url, int duration, School school) {
		this.url = url;
		this.duration = duration;
		this.school = school;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public List<MajorTranslation> getMajorTranslations() {
		return majorTranslations;
	}

	public void setMajorTranslations(List<MajorTranslation> majorTranslations) {
		this.majorTranslations = majorTranslations;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	@Override
	public String toString() {
		return "Major [url=" + url + ", duration=" + duration + ", school=" + school + "]";
	}
}
