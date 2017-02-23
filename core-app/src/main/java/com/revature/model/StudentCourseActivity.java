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
@Table(name = "student_course_activities", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "STUDENT_COURSE_ID", "COURSE_CONTENT_ID" }) })
public class StudentCourseActivity {
	private StudentCourseActivity() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne()
	@JoinColumn(name = "STUDENT_COURSE_ID")
	private StudentCourse studentCourseId;
	@ManyToOne()
	@JoinColumn(name = "COURSE_CONTENT_ID")
	private CourseContent courseContentId;
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

	public StudentCourse getStudentCourseId() {
		return studentCourseId;
	}

	public void setStudentCourseId(StudentCourse studentCourseId) {
		this.studentCourseId = studentCourseId;
	}

	public CourseContent getCourseContentId() {
		return courseContentId;
	}

	public void setCourseContentId(CourseContent courseContentId) {
		this.courseContentId = courseContentId;
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