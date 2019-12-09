package com.zhiyou.service.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhiyou.mapper.AdminMapper;
import com.zhiyou.model.Admin;
import com.zhiyou.model.Course;
import com.zhiyou.model.Subject;
import com.zhiyou.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminMapper mapper;
	
	@Transactional

	public boolean select(String accounts, String password, HttpServletRequest req) {
		Admin admin = mapper.select(accounts); 
		if(admin!=null) {
			if (admin.getPassword().equals(password)) {
				req.getSession().setAttribute("admin", admin);			
				return true ;
			}else {
				return false ;
			}
		}else {
			return false;
		}
	}

	public void add(Course course) {
		mapper.add(course);
		
	}

	public void update(Course course) {
		mapper.update(course);
		
	}

	public List<Subject> selectSubject() {
		
		return mapper.selectSubject();
	}

	public Subject selectName(String subject_name) {
		
		return mapper.selectName(subject_name);
	}

	public Course selectByID(Integer id) {
		
		return mapper.selectByID(id);
	}

	public Course selectCourseByID(int id) {
		
		return mapper.selectCourseByID(id);
	}

	public List<Course> selectAll(int page, int number, String course_title) {
		
		return mapper.selectAll(page, number, course_title);
	}

	public int selectCount(String course_title) {
		
		return mapper.selectCount(course_title);
	}

	public void deCourse(Integer id, HttpServletResponse resp) {
		int number = mapper.deCourse(id);
		if (number==1) {
			try {
				resp.getWriter().write("success");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void removeCourse(List<Integer> userIdList, HttpServletResponse resp) {
		int i = mapper.removeCourse(userIdList);
		if (i==userIdList.size()) {
			try {
				resp.getWriter().write("success");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	public boolean selectaccounts(String accounts) {
		Admin admin = mapper.select(accounts);
		if(admin!=null) {
			return false ;
		}else {
			return true;
		}
	}

}
