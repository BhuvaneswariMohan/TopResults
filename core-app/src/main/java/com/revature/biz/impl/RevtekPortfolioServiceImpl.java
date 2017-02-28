package com.revature.biz.impl;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.biz.RevtekPortfolioService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.RevtekPortfolioDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.RevtekPortfolio;

@Service
public class RevtekPortfolioServiceImpl implements RevtekPortfolioService {

	private static Logger logger = Logger.getLogger(RevtekPortfolioServiceImpl.class);

	@Autowired
	private RevtekPortfolioDAO revtekPortfolioDAO;

	public List<RevtekPortfolio> getAboutMeById(Integer studentId) throws BusinessServiceException {
		List<RevtekPortfolio> students;
		try {
			students = revtekPortfolioDAO.getAboutMeById(studentId);
			logger.info("About me details retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);

		}
		return students;
	}

	public List<RevtekPortfolio> getQualificationById(Integer studentId) throws BusinessServiceException {
		List<RevtekPortfolio> students;
		try {
			students = revtekPortfolioDAO.getQualificationById(studentId);
			logger.info("qualification details retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);

		}
		return students;
	}
}
