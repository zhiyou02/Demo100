package com.zhiyou.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.model.Course;
import com.zhiyou.model.User;
import com.zhiyou.model.Video;
import com.zhiyou.service.CourseService;
import com.zhiyou.service.SpeakerService;
import com.zhiyou.service.UserService;
import com.zhiyou.service.VideoService;


@Controller
public class CourseController {
	@Autowired
	CourseService Service;
	@Autowired
	UserService service1;
	@Autowired
	SpeakerService speakerservice;
	@Autowired
	VideoService videoservice;
	
	
	@RequestMapping("/webClass")
	public  void  webClass(String accounts,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		User user = service1.selectByAccounts(accounts);
		int	subject_id=1;
		//获取到该学科下所有课程
		List<Course> list = Service.selectAll(subject_id);	
		req.setAttribute("list", list);
		req.setAttribute("user", user);
		req.setAttribute("subject_id", subject_id);
		req.getRequestDispatcher("jsp/webShow.jsp").forward(req, resp);
	}
	@RequestMapping("/uiClass")
	public  void  uiClass(String accounts,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		User user = service1.selectByAccounts(accounts);
		int	subject_id=6;
		//获取到该学科下所有课程
		List<Course> list = Service.selectAll(subject_id);	
		req.setAttribute("list", list);
		req.setAttribute("user", user);
		req.setAttribute("subject_id", subject_id);
		req.getRequestDispatcher("jsp/webShow.jsp").forward(req, resp);
	}
	@RequestMapping("/pyClass")
	public  void  pyClass(String accounts,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		User user = service1.selectByAccounts(accounts);
		int	subject_id=10;
		//获取到该学科下所有课程
		List<Course> list = Service.selectAll(subject_id);	
		req.setAttribute("list", list);
		req.setAttribute("user", user);
		req.setAttribute("subject_id", subject_id);
		req.getRequestDispatcher("jsp/webShow.jsp").forward(req, resp);
	}
	@RequestMapping("/phpClass")
	public  void  phpClass(String accounts,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		User user = service1.selectByAccounts(accounts);
		int	subject_id=11;
		//获取到该学科下所有课程
		List<Course> list = Service.selectAll(subject_id);	
		req.setAttribute("list", list);
		req.setAttribute("user", user);
		req.setAttribute("subject_id", subject_id);
		req.getRequestDispatcher("jsp/webShow.jsp").forward(req, resp);
	}
	
	@RequestMapping("/playvideo") 
	public  void  play(Integer video_id,Integer subject_id,HttpServletRequest req,HttpServletResponse resp, Integer id) throws Exception{
		
        User user = service1.selectByID(id);
		req.setAttribute("user", user);	
		
		Video video1 = videoservice.selectByID(video_id);
		Integer play_num = video1.getPlay_num();
		video1.setPlay_num(play_num+1);
		videoservice.update(video1);
		
		//获取视频地址和老师信息
		List<Video> video = videoservice.selectVideoUrl(video_id);
		
		//查询课程信息和教师信息
		List<Video> video2 = videoservice.selectAlls(subject_id);
		//创建一个集合用来接收以上两条数据
		List<List> list = new ArrayList<List>();
		list.add(video);
		list.add(video2);
		
		req.setAttribute("list",list);
		
		
		req.getRequestDispatcher("jsp/playVideo.jsp").forward(req, resp);
	}

}
