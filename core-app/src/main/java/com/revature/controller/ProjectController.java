package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.biz.ProjectService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.Project;

@RestController
@RequestMapping("/")
public class ProjectController {

	private static Logger logger = Logger.getLogger(CourseController.class);

	@Autowired
	private ProjectService projectService;

	@RequestMapping("/topprojects")
	public List<Project> getTopProjects() {
		List<Project> projects = null;
		try {
			logger.info("Getting the projects data...");
			projects = projectService.getTopProjects();
			logger.info("Projects data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return projects;
	}
}
