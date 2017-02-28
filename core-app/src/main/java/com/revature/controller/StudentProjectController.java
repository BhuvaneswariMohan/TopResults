package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.biz.StudentProjectService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.StudentProject;

@RestController
@RequestMapping("/")
public class StudentProjectController {

	private static Logger logger = Logger.getLogger(StudentProjectController.class);

	@Autowired
	private StudentProjectService studentProjectService;

	@RequestMapping("/studentProjects")
	public List<StudentProject> getProjectsTakenByStudents() {
		List<StudentProject> studentProject = null;
		try {
			logger.info("Getting the student projects data...");
			studentProject = studentProjectService.getProjectsTakenByStudents();
			logger.info("Student Projects data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return studentProject;

	}
}
