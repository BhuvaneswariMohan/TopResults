package com.revature.biz.impl;

import java.math.BigInteger;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.biz.ProjectService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.ProjectDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.Project;

@Service
public class ProjectServiceImpl implements ProjectService {

	private static Logger logger = Logger.getLogger(ProjectServiceImpl.class);

	@Autowired
	private ProjectDAO projectDAO;

	public List<Project> getTopProjects() throws BusinessServiceException {
		List<Project> projects;
		try {
			projects = projectDAO.getTopProjects();
			logger.info("Projects retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);

		}
		return projects;
	}
	public List<Project> getProjectTitle() throws BusinessServiceException {
		List<Project> projects;
		try {
			projects = projectDAO.getProjectTitle();
			logger.info("Project titles retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);

		}
		return projects;
	}
	public BigInteger getProjectEnrolledCount(Integer projectId) throws BusinessServiceException {
		BigInteger studentCount;
		try {
			studentCount = projectDAO.getProjectEnrolledCount(projectId);
			logger.info("Project retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentCount;
	}
	public List<Project> getDetails(String project) throws BusinessServiceException {
		List<Project> projects = null;
		try {
			projects = projectDAO.getProjectdetailsbyname(project);
			logger.info("Project details retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return projects;
	}
}
