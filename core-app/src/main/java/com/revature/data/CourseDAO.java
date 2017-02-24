package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.Course;

public interface CourseDAO {
	public List<Course> getAllCourses() throws DataServiceException;

	public List<Course> getTopCourses() throws DataServiceException;
}
