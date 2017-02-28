package com.revature.biz.impl;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.biz.StudentProjectService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.StudentProjectDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.StudentProject;

@Service
public class StudentProjectServiceImpl implements StudentProjectService {

	private static Logger logger = Logger.getLogger(StudentProjectServiceImpl.class);

	@Autowired
	private StudentProjectDAO studentProjectDAO;

	public List<StudentProject> getProjectsTakenByStudents() throws BusinessServiceException {
		List<StudentProject> studentProject;
		try {
			studentProject = studentProjectDAO.getProjectsTakenByStudents();
			logger.info("Student projects retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);

		}
		return studentProject;
	}
}
