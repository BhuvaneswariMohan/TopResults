package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.biz.RevtekStudentService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.RevtekStudentDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.RevtekStudent;

@Service
public class RevtekStudentServiceImpl implements RevtekStudentService {

	private static Logger logger = Logger.getLogger(RevtekStudentServiceImpl.class);

	@Autowired
	private RevtekStudentDAO studentDAO;

	@Override
	public List<RevtekStudent> getAllRevtekStudents() throws BusinessServiceException {
		List<RevtekStudent> students = null;
		try {
			students = studentDAO.getAllRevtekStudents();
			logger.info("Students retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return students;
	}
	public int getCountOfStudents() throws BusinessServiceException {
		int studentCount;
		try {
			studentCount = studentDAO.getCountOfStudents();
			logger.info("Student count retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentCount;
}
}