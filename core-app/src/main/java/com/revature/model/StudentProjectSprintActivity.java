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
@Table(name = "student_project_sprint_activities", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "STUDENT_PROJECTS_SPRINTS_ID", "PROJECT_SPRINT_ACTIVITIES_ID" }) })
public class StudentProjectSprintActivity {
	private StudentProjectSprintActivity() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne()
	@JoinColumn(name = "STUDENT_PROJECTS_SPRINTS_ID")
	private StudentProjectSprint studentProjectSprintId;
	@ManyToOne()
	@JoinColumn(name = "PROJECT_SPRINT_ACTIVITIES_ID")
	private ProjectSprintActivity projectSprintActivityId;
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