package com.revature.biz.impl;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.biz.StudentCourseService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.StudentCourseDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.StudentCourse;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {

	private static Logger logger = Logger.getLogger(StudentCourseServiceImpl.class);

	@Autowired
	private StudentCourseDAO studentCourseDAO;

	public List<StudentCourse> getCoursesTakenByStudents() throws BusinessServiceException {
		List<StudentCourse> studentCourse;
		try {
			studentCourse = studentCourseDAO.getCoursesTakenByStudents();
			logger.info("Student courses retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);

		}
		return studentCourse;
	}
}
