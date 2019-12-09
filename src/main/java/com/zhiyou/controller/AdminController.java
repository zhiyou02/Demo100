package com.zhiyou.controller;


import java.util.Arrays;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhiyou.model.Course;
import com.zhiyou.model.Subject;
import com.zhiyou.service.AdminService;

@Controller
public class AdminController {
	@Autowired
	AdminService service;
	
	@RequestMapping("admin")
	public void login(String accounts,String pwd,HttpServletRequest req,HttpServletResponse resp) throws Exception {
		boolean b = service.select(accounts, pwd,req);
		resp.getWriter().write(b+""); 	
		
	}
	@RequestMapping("/selectAll")
	public String selectAll(HttpServletRequest request,HttpServletResponse resp) {
		 
		String course_title = request.getParameter("course_title")==null?"":request.getParameter("course_title");
		int count = service.selectCount(course_title);
		int page=request.getParameter("page")==null||request.getParameter("page")==""? 1:Integer.valueOf(request.getParameter("page"));
		request.setAttribute("page", page);
		request.setAttribute("count", count);
		List<Course> list = service.selectAll((page-1)*5,5,course_title);
		request.setAttribute("course_title", course_title);
		request.setAttribute("list", list);
		return "/spporter";
		
		
		
		
		
	}
	@RequestMapping("/updateCourse")
	public String update(Course course, HttpServletRequest req,HttpServletResponse resp) {
		service.update(course);
		return "redirect:selectAll";
	}
	//点击添加去得地方
	@RequestMapping("add")
	public String SelectSubject( HttpServletRequest req,HttpServletResponse resp) {
		List<Subject> Subject = service.selectSubject();
		req.setAttribute("list", Subject);
		return "/insertClass";
	}
	@RequestMapping("addCourse")
	public String addCourse( HttpServletRequest req,HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("utf-8");
		String course_title = req.getParameter("course_title");
		String course_desc = req.getParameter("course_desc");
		String subject_name = req.getParameter("subject_name");
		Subject subject = service.selectName(subject_name);
		Integer subject_id = subject.getSubject_id();
		Course course=new Course(null,course_title,course_desc,subject_id, null, null);
		service.add(course);
		return "redirect:selectAll";
	}

	//数据回显
	@RequestMapping("selectCourseByID")
	public String selectCourseByID(Integer id ,HttpServletRequest req,HttpServletResponse resp) {
		Course course = service.selectCourseByID(id);
		Integer id2 = course.getSubject_id();
		List<Subject> subject = service.selectSubject();
		req.setAttribute("id", id2);
		req.setAttribute("subject", subject);
		req.setAttribute("course", course);
		return "/updateClass";
	}
	@RequestMapping("delCourse")
	public void delCourse(Integer id, HttpServletRequest req,HttpServletResponse resp) {
		service.deCourse(id,resp);
	}
	@RequestMapping("deleteAll")
		public void deleteUser(@RequestParam("userIds[]") Integer[] userIds ,HttpServletResponse resp){
				List<Integer> userIdList = Arrays.asList(userIds);
				System.out.println(userIdList);
				service.removeCourse(userIdList, resp);
			
	}


}
