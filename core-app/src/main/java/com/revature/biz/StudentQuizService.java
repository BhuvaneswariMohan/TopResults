package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.StudentQuiz;

public interface StudentQuizService {
	public List<StudentQuiz> getQuizzesTakenByStudents() throws BusinessServiceException;
}
