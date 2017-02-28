package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.User;



public interface UserDAO {
	

	public List<User> getUserdetailsbyid(Integer userid) throws DataServiceException;
	public List<User> getUserloginbyid(String emailid,String password) throws DataServiceException;

	

	

}
