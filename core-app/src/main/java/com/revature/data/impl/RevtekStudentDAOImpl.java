package com.revature.data.impl;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.revature.data.RevtekStudentDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.RevtekStudent;

@Repository
public class RevtekStudentDAOImpl implements RevtekStudentDAO {
	private static Logger logger = Logger.getLogger(RevtekStudentDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	@Override
	public List<RevtekStudent> getAllRevtekStudents() throws DataServiceException {
		List<RevtekStudent> students = null;
		try {
			StringBuilder sb = new StringBuilder("SELECT st.NAME AS stu_name,un.NAME as university_name,st.REGISTERED_ON FROM revtek_students AS st JOIN seed_universities AS un ON (un.ID = st.UNIVERSITY_ID)");
			students = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Students data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return students;
	}
	public int getCountOfStudents() throws DataServiceException
	{
	int studentCount;
		try {
			StringBuilder sb = new StringBuilder("SELECT COUNT(id) FROM revtek_students");
			studentCount = dataRetriver.retrieveBySQLInt(sb.toString());
			logger.info("Students one data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentCount;	
	}

}
