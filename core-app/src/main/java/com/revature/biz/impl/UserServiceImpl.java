package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.UserService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.UserDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.User;


@Service
public class UserServiceImpl implements UserService {

	private static Logger logger = Logger.getLogger(CategoryServiceImpl.class);

	@Autowired
	private UserDAO userDAO;

	@Override
	public List<User> getDetails(Integer userid) throws BusinessServiceException {
		List<User> users = null;
		try {
			users = userDAO.getUserdetailsbyid(userid);
			logger.info("users retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return users;
	}
	public List<User> getUserloginbyid(String emailid,String password) throws BusinessServiceException{
		List<User> users = null;
		try {
			users = userDAO.getUserloginbyid(emailid,password);
			logger.info("users retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return users;
	}
}

