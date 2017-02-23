package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "quizzes")
public class Quiz {
	private Quiz() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	@ManyToOne()
	@JoinColumn(name = "CATEGORY_ID")
	private Category categoryid;

	@Column(name = "NO_OF_ATTEMPTS")
	private Integer noOfAttempts;
	@Column(name = "PASS_PERCENTAGE")
	private Float passPercentage;
	@Column(name = "ACTIVITY_POINTS")
	private Integer activityPoints;
	@Column(name = "IS_ACTIVE")
	private Boolean isActive;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Category getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Category categoryid) {
		this.categoryid = categoryid;
	}

	public Integer getNoOfAttempts() {
		return noOfAttempts;
	}

	public void setNoOfAttempts(Integer noOfAttempts) {
		this.noOfAttempts = noOfAttempts;
	}

	public Float getPassPercentage() {
		return passPercentage;
	}

	public void setPassPercentage(Float passPercentage) {
		this.passPercentage = passPercentage;
	}

	public Integer getActivityPoints() {
		return activityPoints;
	}

	public void setActivityPoints(Integer activityPoints) {
		this.activityPoints = activityPoints;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}