package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.RevtekPortfolio;

public interface RevtekPortfolioDAO {
	public List<RevtekPortfolio> getAboutMeById(Integer studentId) throws DataServiceException;
	public List<RevtekPortfolio> getQualificationById(Integer studentId) throws DataServiceException;
}
