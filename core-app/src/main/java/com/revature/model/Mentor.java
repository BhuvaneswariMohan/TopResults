package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "mentors",uniqueConstraints={
		@UniqueConstraint(columnNames={"NAME"})})
public class Mentor {
	private Mentor(){
		
	}
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  
  private Integer id;
  private String name;
  @Column(name = "EMAIL_ID")
  private String emailid;
  @Column(name = "IS_ACTIVE")
  private Boolean isActive=true;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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

public String getEmailid() {
	return emailid;
}

public void setEmailid(String emailid) {
	this.emailid = emailid;
}
}