package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.StudentProject;

public interface StudentProjectService {
	public List<StudentProject> getProjectsTakenByStudents() throws BusinessServiceException;
}
