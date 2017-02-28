package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.revature.data.StudentQuizDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.StudentQuiz;

@Repository
public class StudentQuizDAOImpl implements StudentQuizDAO {
	private static Logger logger = Logger.getLogger(StudentQuizDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	public List<StudentQuiz> getQuizzesTakenByStudents() throws DataServiceException {
		List<StudentQuiz> studentQuizzes = null;
		try {
			StringBuilder sb = new StringBuilder("SELECT * FROM GET_QUIZZES_TAKEN_BY_STUDENTS ");
			studentQuizzes = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Success");

		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("Failed"));

		}
		return studentQuizzes;
	}
}
