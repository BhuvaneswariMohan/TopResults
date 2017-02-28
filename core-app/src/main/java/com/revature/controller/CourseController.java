package com.revature.controller;

import java.math.BigInteger;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.biz.CourseService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.Course;

@RestController
@RequestMapping("/")
public class CourseController {

	private static Logger logger = Logger.getLogger(CourseController.class);

	@Autowired
	private CourseService courseService;

	@RequestMapping("/courses")
	public List<Course> getActiveCoursesController() {
		List<Course> courses = null;
		try {
			logger.info("Getting the courses data...");
			courses = courseService.getAllCourses();
			logger.info("courses data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return courses;
	}

	@RequestMapping("/topcourses")
	public List<Course> getTopCourses() {
		List<Course> courses = null;
		try {
			logger.info("Getting the courses data...");
			courses = courseService.getTopCourses();
			logger.info("courses data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return courses;
	}

	@RequestMapping("/coursetitles")
	public List<Course> getCourseTitles() {
		List<Course> courses = null;
		try {
			logger.info("Getting the course titles data...");
			courses = courseService.getCourseTitles();
			logger.info("course title data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return courses;
	}

	@RequestMapping("/studentsenrolledforcourses")
	public BigInteger getCourseEnrolledCount(Integer courseId) {
		BigInteger studentCount;
		try {
			logger.info("Getting the enrolled students for course data...");
			studentCount = courseService.getCourseEnrolledCount(courseId);
			logger.info("Courses enrolled data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return studentCount;

	}

	@RequestMapping("/coursedetails")
	public List<Course> getDetailsController(String Course) {
		List<Course> courses = null;
		try {
			logger.info("Getting the course details data...");
			courses = courseService.getDetails(Course);
			return courses;
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
	}
}
