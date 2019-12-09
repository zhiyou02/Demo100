package com.zhiyou.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhiyou.model.Course;

public interface CourseMapper {

	List<Course> selectAll(int id);    
	Course selectByID(@Param("id")int id);

}
