package com.revature.biz;

import java.math.BigInteger;
import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.Quiz;

public interface QuizService {
	public List<Quiz> getTopQuizzes() throws BusinessServiceException;

	public List<Quiz> getQuizTitles() throws BusinessServiceException;

	public BigInteger getQuizEnrolledCount(Integer quizId) throws BusinessServiceException;

	public List<Quiz> getDetails(String quiz) throws BusinessServiceException;
}
