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

@Entity
@Table(name = "qualifications")
public class Qualification {
	private Qualification() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne()
	@JoinColumn(name = "DEGREE_ID")
	private SeedDegree degree;
	@ManyToOne()
	@JoinColumn(name = "MAJOR_ID")
	private SeedMajor major;
	private String university;
	private Float cgpa;
	@Column(name = "GRADUATION_MONTH")
	@Temporal(TemporalType.DATE)
	private Date graduationMonth;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SeedDegree getDegree() {
		return degree;
	}

	public void setDegree(SeedDegree degree) {
		this.degree = degree;
	}

	public SeedMajor getMajor() {
		return major;
	}

	public void setMajor(SeedMajor major) {
		this.major = major;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public Float getCgpa() {
		return cgpa;
	}

	public void setCgpa(Float cgpa) {
		this.cgpa = cgpa;
	}

	public Date getGraduationMonth() {
		return graduationMonth;
	}

	public void setGraduationMonth(Date graduationMonth) {
		this.graduationMonth = graduationMonth;
	}

}