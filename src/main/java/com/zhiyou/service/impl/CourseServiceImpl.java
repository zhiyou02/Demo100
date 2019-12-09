package com.zhiyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhiyou.mapper.CourseMapper;
import com.zhiyou.model.Course;
import com.zhiyou.service.CourseService;
@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	CourseMapper mapper;
	
	@Transactional

	public Course selectByID(int id) {
		
		return mapper.selectByID(id);
	}

	public List<Course> selectAll(int id) {
		
		return mapper.selectAll(id);
	}
	
	


}
