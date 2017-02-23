package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.RevtekStudent;

public interface RevtekStudentService {
	List<RevtekStudent> getAllRevtekStudents() throws BusinessServiceException;
	public int getCountOfStudents() throws BusinessServiceException;
}
