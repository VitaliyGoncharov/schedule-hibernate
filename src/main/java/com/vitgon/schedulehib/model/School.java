package com.vitgon.schedulehib.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.vitgon.schedulehib.model.translation.SchoolTranslation;

@Entity
@Table(name = "school")
public class School extends BaseModel<Integer> {
	
	@Column(name = "url")
	private String url;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "school")
	private List<Major> majors = new ArrayList<>();
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "school")
	private List<SchoolTranslation> schoolTranslations = new ArrayList<>();
	
	public School() {
	}

	public School(List<SchoolTranslation> schoolTranslations, String url, List<Major> majors) {
		this.schoolTranslations = schoolTranslations;
		this.url = url;
		this.majors = majors;
	}

	public School(String url, List<Major> majors) {
		this.url = url;
		this.majors = majors;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Major> getMajors() {
		return majors;
	}

	public void setMajors(List<Major> majors) {
		this.majors = majors;
	}

	public List<SchoolTranslation> getSchoolTranslations() {
		return schoolTranslations;
	}

	public void setSchoolTranslations(List<SchoolTranslation> schoolTranslations) {
		this.schoolTranslations = schoolTranslations;
	}

	@Override
	public String toString() {
		return "School [id=" + getId()+ ", url=" + url + ", majors=" + majors + "]";
	}
}
