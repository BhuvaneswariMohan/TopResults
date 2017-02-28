package com.revature.data;

import java.math.BigInteger;
import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.RevtekStudent;

public interface RevtekStudentDAO {

	public List<RevtekStudent> getAllRevtekStudents() throws DataServiceException;

	public BigInteger getCountOfStudents() throws DataServiceException;

	public List<RevtekStudent> getStudentsListByDateOfEnroll() throws DataServiceException;

	public BigInteger getStudentsCountEnrolledForTheDay() throws DataServiceException;

}
