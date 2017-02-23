package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.biz.RevtekStudentService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.RevtekStudent;

@RestController
@RequestMapping("/")
public class RevtekStudentController {

	private static Logger logger = Logger.getLogger(CategoryController.class);

	@Autowired
	private RevtekStudentService studentService;

	@RequestMapping("/students")
	public List<RevtekStudent> getActiveStudentsController() {
		List<RevtekStudent> students = null;
		try {
			logger.info("Getting the students data...");
			students = studentService.getAllRevtekStudents();
			logger.info("Students data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return students;
	}
	@RequestMapping("/studentcount")
	public int getStudentCount(){
		int studentCount;
		try {
			logger.info("Getting the students data...");
			studentCount = studentService.getCountOfStudents();
			logger.info("Students count data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return studentCount;
		
	}
}
