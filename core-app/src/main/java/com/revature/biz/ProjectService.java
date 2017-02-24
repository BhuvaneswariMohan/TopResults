package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.Project;

public interface ProjectService {
	public List<Project> getTopProjects() throws BusinessServiceException;
}
