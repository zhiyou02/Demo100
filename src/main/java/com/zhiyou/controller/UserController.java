package com.zhiyou.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou.model.User;
import com.zhiyou.service.UserService;
import com.zhiyou.util.FtpUtil;
@Controller
public class UserController {
	
	@Autowired
	UserService service;
	/**
	 * �û���¼
	 */
	@RequestMapping("login")
	public void login(HttpServletRequest req,HttpServletResponse resp,User user, String accounts ) throws ServletException, IOException {
		req.setAttribute("user",service.selectByAccounts(accounts));		
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	/**
	 * ��������
	 */
	@RequestMapping("/user")
	public void selectByAccounts(HttpServletRequest req,HttpServletResponse resp,User user, int id ) throws ServletException, IOException {
		req.setAttribute("user",service.selectByID(id));		
		req.getRequestDispatcher("/jsp/user.jsp").forward(req, resp);
	}
	/**
	 * ������ҳ
	 */
	@RequestMapping("index")
	public void index(HttpServletRequest req,HttpServletResponse resp, User user, int id) throws ServletException, IOException {
		req.setAttribute("user", service.selectByID(id));
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	/**
	 * ע��
	 */
	@RequestMapping("insertUser")
	public void addUser(HttpServletRequest req,HttpServletResponse resp, User user) throws ServletException, IOException {
		service.add(user);
		User user2 = service.selectByAccounts(user.getAccounts());
		req.setAttribute("user", user2);
		req.getRequestDispatcher("index.jsp").forward(req, resp);		
	}
	/**
	 * ��ת��������ҳ��
	 */
	@RequestMapping("userUp")
	public void userUp(HttpServletRequest req,HttpServletResponse resp, User user, int id) throws ServletException, IOException {
		req.setAttribute("user", service.selectByID(id));
		req.getRequestDispatcher("/jsp/userUpdate.jsp").forward(req, resp);
	}
	@RequestMapping("updateUser")
	public void update(HttpServletRequest req,HttpServletResponse resp, User user, int id) throws ServletException, IOException {
		service.update(user);
		 req.setAttribute("user", service.selectByID(id));
		req.getRequestDispatcher("/jsp/user.jsp").forward(req, resp);
		
	}
	/**
	 * ��ת����ͷ��ҳ��
	 */
	@RequestMapping("chartUp")
	public void chartUp(HttpServletRequest req,HttpServletResponse resp, User user, int id) throws ServletException, IOException {
		req.setAttribute("user", service.selectByID(id));
		req.getRequestDispatcher("/jsp/chart.jsp").forward(req, resp);
	}
	@RequestMapping("upload")
	public void upload(MultipartFile image_file,HttpServletRequest req,HttpServletResponse resp, User user, int id) throws Exception {
		 
		String upload = FtpUtil.upload(image_file.getInputStream(), image_file.getOriginalFilename());
//	    System.out.println(upload);
		user.setImgurl(upload);
		service.update(user);
		req.setAttribute("user", service.selectByID(id));
		req.getRequestDispatcher("/jsp/user.jsp").forward(req, resp);
		
	}
	/**
	 * ��ת��������ҳ��
	 */
	@RequestMapping("passwordUp")
	public void passwordUp(HttpServletRequest req,HttpServletResponse resp, User user, int id) throws ServletException, IOException {
		req.setAttribute("user", service.selectByID(id));
		req.getRequestDispatcher("/jsp/password.jsp").forward(req, resp);
	}
	@RequestMapping("updatepassword")
	public void updatePassword(HttpServletRequest req,HttpServletResponse resp, User user, int id) throws ServletException, IOException {
		service.update(user);
		req.setAttribute("user", service.selectByID(id));
		req.getRequestDispatcher("/jsp/user.jsp").forward(req, resp);
	}
	
	/**
	 * ��������
	 */
	@RequestMapping("forgetpassword")
	public void forgetpwd(HttpServletRequest req,HttpServletResponse resp, User user, int id) throws ServletException, IOException {
		User user2 =service.selectByAccounts(user.getAccounts());
		req.setAttribute("user", user2);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

	

	
}
