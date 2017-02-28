package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.StudentCourse;

public interface StudentCourseService {
	public List<StudentCourse> getCoursesTakenByStudents() throws BusinessServiceException;
}