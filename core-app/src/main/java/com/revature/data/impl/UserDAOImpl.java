package com.revature.data.impl;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.UserDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.User;




@Repository
public class UserDAOImpl implements UserDAO {
  private static Logger logger = Logger.getLogger(UserDAOImpl.class);
  @Autowired
  private DataRetriver dataRetriver;

  public DataRetriver getDataRetriver() {
    return dataRetriver;
  }


  public void setDataRetriver(DataRetriver dataRetriver) {
    this.dataRetriver = dataRetriver;
  }


  @Override
  public List<User> getUserdetailsbyid(Integer userid) throws DataServiceException {
    List<User> users = null;
    try {
      StringBuilder sb = new StringBuilder("SELECT USERNAME,EMAIL_ID FROM users WHERE users.ID ="+userid);
      users = dataRetriver.retrieveBySQL(sb.toString());
      logger.info("Users data retrieval success.."+users);
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
    }
    return users;
  }
 public List<User> getUserloginbyid(String emailid,String password) throws DataServiceException {
	 List<User> users = null;
	    try {
	      StringBuilder sb = new StringBuilder("SELECT ID FROM users WHERE USERNAME='"+emailid+"'"+" and PASSWORD='"+password+"'");
	      users = dataRetriver.retrieveBySQL(sb.toString());
	      System.out.println(users);
	      
	      logger.info("Users data retrieval success..");
	    } catch (DataAccessException e) {
	      logger.error(e.getMessage(), e);
	      throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
	    }
	    return users;
 }
}


