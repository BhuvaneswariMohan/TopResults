package com.revature.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "student_project_sprints", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "STUDENT_PROJECT_ID", "PROJECT_SPRINTS_ID" }) })
public class StudentProjectSprint {
	private StudentProjectSprint() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne()
	@JoinColumn(name = "STUDENT_PROJECT_ID")
	private StudentProject studentProjectId;
	@ManyToOne()
	@JoinColumn(name = "PROJECT_SPRINTS_ID")
	private ProjectSprint projectSprintId;
	@Column(name = "STARTED_ON")
	@Temporal(TemporalType.DATE)
	private Date startedOn;
	@Column(name = "COMPLETED_ON")
	@Temporal(TemporalType.DATE)
	private Date completedOn;
	@ManyToOne
	@JoinColumn(name = "STATUS")
	private SeedStatus statusId;
}