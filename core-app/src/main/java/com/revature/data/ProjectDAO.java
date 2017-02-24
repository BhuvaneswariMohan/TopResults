package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.Project;

public interface ProjectDAO {
	public List<Project> getTopProjects() throws DataServiceException;
}
