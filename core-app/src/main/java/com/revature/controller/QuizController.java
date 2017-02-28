package com.revature.controller;

import java.math.BigInteger;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.biz.QuizService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.Quiz;

@RestController
@RequestMapping("/")
public class QuizController {

	private static Logger logger = Logger.getLogger(QuizController.class);

	@Autowired
	private QuizService quizService;

	@RequestMapping("/topquizzes")
	public List<Quiz> getTopQuizzes() {
		List<Quiz> quizzes = null;
		try {
			logger.info("Getting the quizzes data...");
			quizzes = quizService.getTopQuizzes();
			logger.info("Quizzes data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return quizzes;
	}

	@RequestMapping("/quiztitles")
	public List<Quiz> getQuizTitles() {
		List<Quiz> quizzes = null;
		try {
			logger.info("Getting the quiz titles data...");
			quizzes = quizService.getQuizTitles();
			logger.info("Quiz titles data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return quizzes;
	}

	@RequestMapping("/studentsenrolledforquizzes")
	public BigInteger getQuizEnrolledCount(Integer quizId) {
		BigInteger studentCount;
		try {
			logger.info("Getting the enrolled students for quizzes data...");
			studentCount = quizService.getQuizEnrolledCount(quizId);
			logger.info("quizzes enrolled data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return studentCount;

	}

	@RequestMapping("/quizdetails")
	public List<Quiz> getDetailsController(String quiz) {
		try {
			logger.info("Getting the quizzes data...");
			return quizService.getDetails(quiz);
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
	}
}
