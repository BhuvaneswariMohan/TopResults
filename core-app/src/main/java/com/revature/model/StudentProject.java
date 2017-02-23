package com.revature.model;

import java.time.LocalTime;

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
@Table(name = "student_projects", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "STUDENT_ID", "PROJECT_ID" }) })
public class StudentProject {
	private StudentProject() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne()
	@JoinColumn(name = "STUDENT_ID")
	private RevtekStudent studentid;
	@ManyToOne()
	@JoinColumn(name = "PROJECT_ID")
	private Project projectid;
	@Column(name = "STARTED_ON")
	private LocalTime startedOn;
	@Column(name = "COMPLETED_ON")

	private LocalTime completedOn;
	@ManyToOne()
	@JoinColumn(name = "STATUS")
	private SeedStatus status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RevtekStudent getstudentId() {
		return studentid;
	}

	public void setId(RevtekStudent studentid) {
		this.studentid = studentid;
	}

	public Project getprojectId() {
		return projectid;
	}

	public void setId(Project projectid) {
		this.projectid = projectid;
	}

	public LocalTime getStartedOn() {
		return startedOn;
	}

	public void setStartedOn(LocalTime startedOn) {
		this.startedOn = startedOn;
	}

	public LocalTime getCompletedOn() {
		return completedOn;
	}

	public void setCompletedOn(LocalTime completedOn) {
		this.completedOn = completedOn;
	}

	public SeedStatus getStatus() {
		return status;
	}

	public void setStatus(SeedStatus status) {
		this.status = status;
	}

}