package com.revature.data.impl;

import java.math.BigInteger;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.revature.data.ProjectDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.Project;

@Repository
public class ProjectDAOImpl implements ProjectDAO {
	private static Logger logger = Logger.getLogger(ProjectDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	public List<Project> getTopProjects() throws DataServiceException {
		List<Project> projects = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT projects.`TITLE` AS Project_NAME, COUNT(student_projects.`PROJECT_ID`) AS ENROLLED_STUDENTS FROM student_projects JOIN projects ON projects.`ID` = student_projects.`PROJECT_ID` GROUP BY PROJECT_ID ORDER BY COUNT(PROJECT_ID) DESC");
			projects = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Success");

		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("Failed"));

		}
		return projects;
	}

	public List<Project> getProjectTitle() throws DataServiceException {
		List<Project> projects = null;
		try {
			StringBuilder sb = new StringBuilder("SELECT TITLE,DESCRIPTION FROM projects");
			projects = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Success");

		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("Failed"));

		}
		return projects;
	}

	public BigInteger getProjectEnrolledCount(Integer projectId) throws DataServiceException {
		BigInteger studentCount;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT COUNT(id) FROM student_projects WHERE PROJECT_ID= " + projectId);
			studentCount = (BigInteger) dataRetriver.retrieveBySQLInt(sb.toString());
			logger.info("students enrolled projects data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentCount;
	}

	public List<Project> getProjectdetailsbyname(String project) throws DataServiceException {
		List<Project> projects = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT projects.`TITLE`,projects.`DESCRIPTION`,mentors.`NAME`,mentors.`EMAIL_ID`,projects.`ENROLLMENT_POINTS`,projects.`COMPLETION_POINTS` FROM projects JOIN mentors ON mentors.`ID` = projects.`MENTOR_ID` WHERE projects.`TITLE`="
							+ project);
			projects = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Projects data retrieval success.." + projects);
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return projects;
	}
}
