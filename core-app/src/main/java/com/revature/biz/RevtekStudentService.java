package com.revature.biz;

import java.math.BigInteger;
import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.RevtekStudent;

public interface RevtekStudentService {
	List<RevtekStudent> getAllRevtekStudents() throws BusinessServiceException;

	public BigInteger getCountOfStudents() throws BusinessServiceException;

	List<RevtekStudent> getStudentsListByDateOfEnroll() throws BusinessServiceException;

	public BigInteger getStudentsCountEnrolledForTheDay() throws BusinessServiceException;
}
