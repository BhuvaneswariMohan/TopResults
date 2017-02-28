package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;

import com.revature.model.User;

public interface UserService {

	/**
	 * Used to get all the categories.
	 * 
	 * @return categories
	 * @throws BusinessServiceException
	 *             if any business error occurs
	 */
	List<User> getDetails(Integer userid) throws BusinessServiceException;

	public List<User> getUserloginbyid(String emailid, String password) throws BusinessServiceException;

}