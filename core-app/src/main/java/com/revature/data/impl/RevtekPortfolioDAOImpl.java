package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.revature.data.RevtekPortfolioDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.RevtekPortfolio;

@Repository
public class RevtekPortfolioDAOImpl implements RevtekPortfolioDAO {
	private static Logger logger = Logger.getLogger(RevtekPortfolioDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	@Override
	public List<RevtekPortfolio> getAboutMeById(Integer studentId) throws DataServiceException {
		List<RevtekPortfolio> students = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT revtek_portfolio.`NAME`,revtek_portfolio.`ABOUT_ME`,revtek_students.`MOBILE_NUMBER`,revtek_students.`EMAIL_ID` FROM revtek_portfolio JOIN revtek_students ON revtek_students.`ID` = revtek_portfolio.`STUDENT_ID` WHERE revtek_students.`ID`="+ studentId);
			students = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("About me data retrieval success.." + studentId);
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return students;
	}

	public List<RevtekPortfolio> getQualificationById(Integer studentId) throws DataServiceException {
		List<RevtekPortfolio> students = null;
		try {
			StringBuilder sb = new StringBuilder(
					" SELECT qualifications.`STUDENT_ID`,seed_degrees.`NAME` AS DEGREE,seed_majors.`NAME` AS MAJOR,qualifications.`UNIVERSITY`,qualifications.`CGPA`,qualifications.`GRADUATION_MONTH`,qualifications.`GRADUATION_YEAR` FROM qualifications JOIN revtek_portfolio  ON qualifications.`STUDENT_ID` = revtek_portfolio.`STUDENT_ID` JOIN seed_degrees  ON seed_degrees.`ID` = qualifications.`DEGREE_ID`  JOIN seed_majors ON seed_majors.`ID` = qualifications.`MAJOR_ID`  WHERE revtek_portfolio.`STUDENT_ID`="+studentId);
			students = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Qualification data retrieval success.." + studentId);
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return students;
	}
}
