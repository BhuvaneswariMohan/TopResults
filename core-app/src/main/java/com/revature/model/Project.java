package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "projects", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID", "TITLE" }) })
public class Project {
	private Project() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "TITLE")
	private String title;
	@Column(name = "DESCRIPTION")
	private String decription;
	@ManyToOne()
	@JoinColumn(name = "CATEGORY_ID")
	private Category category;

	@ManyToOne()
	@JoinColumn(name = "MENTOR_ID")
	private Mentor mentor;

	@ManyToOne()
	@JoinColumn(name = "TEASER_VIDEO_ID")
	private Video video;

	@Column(name = "ENROLLMENT_POINTS")
	private Integer enrollmentpoints;

	@Column(name = "COMPLETION_POINTS")
	private Integer completionpoints;
	@Column(name = "IS_ACTIVE")
	private Boolean isActive = true;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategoryid(Category category) {
		this.category = category;
	}

	public Mentor getMentor() {
		return mentor;
	}

	public void setMentorid(Mentor mentor) {
		this.mentor = mentor;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public Integer getEnrollmentpoints() {
		return enrollmentpoints;
	}

	public void setEnrollmentpoints(Integer enrollmentpoints) {
		this.enrollmentpoints = enrollmentpoints;
	}

	public Integer getCompletionpoints() {
		return completionpoints;
	}

	public void setCompletionpoints(Integer completionpoints) {
		this.completionpoints = completionpoints;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
}