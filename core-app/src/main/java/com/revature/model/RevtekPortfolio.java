package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "revtek_portfolio", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID", "NAME" }) })
public class RevtekPortfolio {
	private RevtekPortfolio() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@OneToOne()
	@JoinColumn(name = "STUDENT_ID")
	private RevtekStudent studentId;
	@Column(name = "NAME")
	private String name;
	@ManyToOne()
	@JoinColumn(name = "INDUSTRIAL_EQUIVALENCY_ID")
	private IndustrialEquivalency industrialEquivalencyId;
	@Column(name = "ABOUT_ME")
	private String aboutMe;
	@ManyToOne()
	@JoinColumn(name = "QUALIFICATION_ID")
	private Qualification qualificationId;
	@ManyToOne()
	@JoinColumn(name = "CERTIFICATION_ID")
	private Certification certificationId;
	@Column(name = "IS_ACTIVE")
	private Boolean isActive = true;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RevtekStudent getStudentId() {
		return studentId;
	}

	public void setStudentId(RevtekStudent studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public IndustrialEquivalency getIndustrialEquivalencyId() {
		return industrialEquivalencyId;
	}

	public void setIndustrialEquivalencyId(IndustrialEquivalency industrialEquivalencyId) {
		this.industrialEquivalencyId = industrialEquivalencyId;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public Qualification getQualificationId() {
		return qualificationId;
	}

	public void setQualificationId(Qualification qualificationId) {
		this.qualificationId = qualificationId;
	}

	public Certification getCertificationId() {
		return certificationId;
	}

	public void setCertificationId(Certification certificationId) {
		this.certificationId = certificationId;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
}