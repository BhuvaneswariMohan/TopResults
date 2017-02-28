package com.revature.biz.impl;

import java.math.BigInteger;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.biz.QuizService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.QuizDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.Quiz;

@Service
public class QuizServiceImpl implements QuizService {

	private static Logger logger = Logger.getLogger(QuizServiceImpl.class);

	@Autowired
	private QuizDAO quizDAO;

	public List<Quiz> getTopQuizzes() throws BusinessServiceException {
		List<Quiz> quizzes;
		try {
			quizzes = quizDAO.getTopQuizzes();
			logger.info("Projects retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);

		}
		return quizzes;
	}

	public List<Quiz> getQuizTitles() throws BusinessServiceException {
		List<Quiz> quizzes;
		try {
			quizzes = quizDAO.getQuizTitles();
			logger.info("Quiz titles retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);

		}
		return quizzes;
	}

	public BigInteger getQuizEnrolledCount(Integer quizId) throws BusinessServiceException {
		BigInteger studentCount;
		try {
			studentCount = quizDAO.getQuizEnrolledCount(quizId);
			logger.info("Quiz enrolled students retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentCount;
	}

	public List<Quiz> getDetails(String quiz) throws BusinessServiceException {
		List<Quiz> quizzes = null;
		try {
			quizzes = quizDAO.getQuizdetailsbyname(quiz);
			logger.info("Quiz details retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return quizzes;
	}
}
