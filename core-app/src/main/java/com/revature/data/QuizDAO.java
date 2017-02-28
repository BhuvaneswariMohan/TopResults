package com.revature.data;

import java.math.BigInteger;
import java.util.List;
import com.revature.data.exception.DataServiceException;
import com.revature.model.Quiz;

public interface QuizDAO {
	public List<Quiz> getTopQuizzes() throws DataServiceException;

	public List<Quiz> getQuizTitles() throws DataServiceException;

	public BigInteger getQuizEnrolledCount(Integer quizId) throws DataServiceException;

	public List<Quiz> getQuizdetailsbyname(String quiz) throws DataServiceException;
}
