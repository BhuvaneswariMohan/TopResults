package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.RevtekPortfolio;

public interface RevtekPortfolioService {
	public List<RevtekPortfolio> getAboutMeById(Integer studentId) throws BusinessServiceException;

	public List<RevtekPortfolio> getQualificationById(Integer studentId) throws BusinessServiceException;
}
