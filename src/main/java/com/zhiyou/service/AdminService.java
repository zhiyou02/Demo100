package com.zhiyou.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.model.Course;
import com.zhiyou.model.Subject;

public interface AdminService {
	
	boolean select(String accounts,String password, HttpServletRequest req);
	boolean selectaccounts(String accounts);
	void add(Course course); 
	void update(Course course); 
	
    List<Subject> selectSubject();
    Subject selectName(String subject_name);
    
	Course selectByID(Integer id);
	Course selectCourseByID(int id);
	
	List<Course> selectAll(int page,int number,String course_title);
	int selectCount(String course_title);
	void deCourse(Integer id,HttpServletResponse resp);
	void removeCourse(List<Integer> userIdList,HttpServletResponse resp);

}
