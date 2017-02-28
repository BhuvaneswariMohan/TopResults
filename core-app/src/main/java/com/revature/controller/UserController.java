package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.revature.biz.UserService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.User;

@RestController
@RequestMapping("/")
public class UserController {

	private static Logger logger = Logger.getLogger(ProjectController.class);

	@Autowired
	private UserService userService;

	@RequestMapping("/Users/{userid}")
	public List<User> getDetailsController(@PathVariable("userid") Integer userId) {
		List<User> users = null;
		try {
			logger.info("Getting the users data...");
			users = userService.getDetails(userId);
			return users;
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
	}

	@RequestMapping("/login")
	public List<User> getUserloginbyidController(@RequestParam("emailid") String emailid,
			@RequestParam("password") String password) {
		List<User> users;
		try {
			logger.info("Getting the users data...");
			users = userService.getUserloginbyid(emailid, password);
			return users;
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
	}
}
