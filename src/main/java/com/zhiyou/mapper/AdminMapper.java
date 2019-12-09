package com.zhiyou.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhiyou.model.Admin;
import com.zhiyou.model.Course;
import com.zhiyou.model.Subject;

public interface AdminMapper {
	
	Admin select(String accounts);
	void add(Course course); 
	void update(Course course); 
	
    List<Subject> selectSubject();
    Subject selectName(String subject_name);
    
	Course selectByID(Integer id);
	Course selectCourseByID(int id);
	
	List<Course> selectAll(int page,int number,String course_title);
	int selectCount(String course_title);
	int deCourse(Integer id);
	int removeCourse(@Param("userIdList")List<Integer> userIdList);
	

}
