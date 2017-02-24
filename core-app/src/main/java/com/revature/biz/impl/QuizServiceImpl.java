package com.revature.biz.impl;

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

	private static Logger logger = Logger.getLogger(CourseServiceImpl.class);

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
}
