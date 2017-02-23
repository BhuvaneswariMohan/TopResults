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
	@Table(name = "student_courses",uniqueConstraints = {
		    @UniqueConstraint(columnNames={"STUDENT_ID", "COURSE_ID"})})
	public class StudentCourse {
		private StudentCourse(){
			
		}
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Integer id;
		
		@ManyToOne()
		@JoinColumn(name = "STUDENT_ID")
		private RevtekStudent studentid;
		@ManyToOne()
		@JoinColumn(name = "COURSE_ID")
		private Course courseid;
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
		public RevtekStudent getStudentid() {
			return studentid;
		}
		public void setStudentid(RevtekStudent studentid) {
			this.studentid = studentid;
		}
		public Course getCourseid() {
			return courseid;
		}
		public void setCourseid(Course courseid) {
			this.courseid = courseid;
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