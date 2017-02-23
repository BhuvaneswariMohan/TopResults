package com.revature.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "industrial_equivalency",uniqueConstraints={
		@UniqueConstraint(columnNames={"ID","SKILL_SETS"})})
public class IndustrialEquivalency {
	private IndustrialEquivalency(){
		
	}
      @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
      private Integer id;
      @Column(name="SKILL_SETS")
      private String skillSets;
      @Column(name="EXPERIENCE_IN_MONTHS")
      private Integer experienceInMonths;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getSkillSets() {
        return skillSets;
    }
    public void setSkillSets(String skillSets) {
        this.skillSets = skillSets;
    }
    public Integer getExperienceInMonths() {
        return experienceInMonths;
    }
    public void setExperienceInMonths(Integer experienceInMonths) {
        this.experienceInMonths = experienceInMonths;
    }
      
}