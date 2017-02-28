package com.revature.biz.impl;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.biz.StudentQuizService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.StudentQuizDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.StudentQuiz;
@Service
public class StudentQuizServiceImpl implements StudentQuizService {

	private static Logger logger = Logger.getLogger(StudentQuizServiceImpl.class);

	@Autowired
	private StudentQuizDAO studentQuizDAO;

	public List<StudentQuiz> getQuizzesTakenByStudents() throws BusinessServiceException {
		List<StudentQuiz> studentQuiz;
		try {
			studentQuiz = studentQuizDAO.getQuizzesTakenByStudents();
			logger.info("Student quizzes retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);

		}
		return studentQuiz;
	}
}
