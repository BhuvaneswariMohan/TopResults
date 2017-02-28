package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.StudentProject;

public interface StudentProjectDAO {
public List<StudentProject> getProjectsTakenByStudents() throws DataServiceException;
}
