package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.revature.data.QuizDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.Quiz;

@Repository
public class QuizDAOImpl implements QuizDAO {
	private static Logger logger = Logger.getLogger(CourseDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	public List<Quiz> getTopQuizzes() throws DataServiceException {
		List<Quiz> quizzes = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT quizzes.`TITLE` AS QUIZ_NAME, COUNT(student_quizzes.QUIZ_ID) AS ENROLLED_STUDENTS FROM student_quizzes JOIN quizzes ON quizzes.`ID` = student_quizzes.`QUIZ_ID` GROUP BY QUIZ_ID ORDER BY COUNT(QUIZ_ID) DESC");
			quizzes = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Success");

		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("Failed"));

		}
		return quizzes;
	}
}
