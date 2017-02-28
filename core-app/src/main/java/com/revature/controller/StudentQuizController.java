package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.biz.StudentQuizService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.StudentQuiz;

@RestController
@RequestMapping("/")
public class StudentQuizController {

	private static Logger logger = Logger.getLogger(StudentQuizController.class);

	@Autowired
	private StudentQuizService studentQuizService;

	@RequestMapping("/studentQuizzes")
	public List<StudentQuiz> getQuizzesTakenByStudents() {
		List<StudentQuiz> studentQuiz = null;
		try {
			logger.info("Getting the student courses data...");
			studentQuiz = studentQuizService.getQuizzesTakenByStudents();
			logger.info("Student quizzes data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return studentQuiz;

	}
}
