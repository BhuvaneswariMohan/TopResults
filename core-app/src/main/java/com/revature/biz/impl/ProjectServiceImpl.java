package com.revature.biz.impl;

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

	private static Logger logger = Logger.getLogger(CourseServiceImpl.class);

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
}
