package com.revature.biz.impl;

import java.math.BigInteger;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.biz.CourseService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.CourseDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.Course;

@Service
public class CourseServiceImpl implements CourseService {

	private static Logger logger = Logger.getLogger(CourseServiceImpl.class);

	@Autowired
	private CourseDAO courseDAO;

	@Override
	public List<Course> getAllCourses() throws BusinessServiceException {
		List<Course> courses = null;
		try {
			courses = courseDAO.getAllCourses();
			logger.info("Courses retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return courses;
	}

	public List<Course> getTopCourses() throws BusinessServiceException {
		List<Course> courses;
		try {
			courses = courseDAO.getTopCourses();
			logger.info("Courses retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);

		}
		return courses;
	}

	public List<Course> getCourseTitles() throws BusinessServiceException {
		List<Course> courses;
		try {
			courses = courseDAO.getCourseTitles();
			logger.info("Course titles retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);

		}
		return courses;
	}

	public BigInteger getCourseEnrolledCount(Integer courseId) throws BusinessServiceException {
		BigInteger studentCount;
		try {
			studentCount = courseDAO.getCourseEnrolledCount(courseId);
			logger.info("Courses count retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentCount;
	}

	public List<Course> getDetails(String course) throws BusinessServiceException {
		List<Course> courses = null;
		try {
			courses = courseDAO.getCoursedetailsbyname(course);
			logger.info("courses retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return courses;
	}
}
