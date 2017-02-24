package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;

import com.revature.model.Course;

public interface CourseService {
	List<Course> getAllCourses() throws BusinessServiceException;
	public List<Course> getTopCourses() throws BusinessServiceException;
}
