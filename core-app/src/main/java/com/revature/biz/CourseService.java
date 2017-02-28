package com.revature.biz;

import java.math.BigInteger;
import java.util.List;

import com.revature.biz.exception.BusinessServiceException;

import com.revature.model.Course;

public interface CourseService {
	List<Course> getAllCourses() throws BusinessServiceException;

	public List<Course> getTopCourses() throws BusinessServiceException;

	public List<Course> getCourseTitles() throws BusinessServiceException;

	public BigInteger getCourseEnrolledCount(Integer courseId) throws BusinessServiceException;

	public List<Course> getDetails(String Course) throws BusinessServiceException;
}
