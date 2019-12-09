package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.Course;

public interface CourseService {

	    
	Course selectByID(int id);
	List<Course> selectAll(int id); 

}
