package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.RevtekStudent;

public interface RevtekStudentDAO {

	public List<RevtekStudent> getAllRevtekStudents() throws DataServiceException;

	public int getCountOfStudents() throws DataServiceException;

	public List<RevtekStudent> getStudentsListByDateOfEnroll() throws DataServiceException;

}
