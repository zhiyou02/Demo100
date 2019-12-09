package com.zhiyou.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.model.User;
import com.zhiyou.service.AdminService;
import com.zhiyou.service.UserService;

@Controller
public class LoginController {
	@Autowired
	UserService service;
	@Autowired
	AdminService adminservice;
	
	/**
	 * @��¼
	 */
	@RequestMapping("/login")
	public void  login(String accounts,String password,HttpServletRequest req,HttpServletResponse resp) throws Exception {
		User user = service.loginSelect(req, accounts, password);
		req.setAttribute("user", user);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	
	/**
	 * @�˺ŵ�ajax��֤
	 */
	@RequestMapping("/loginjudge")
	public void  loginjudge(String name,HttpServletRequest req,HttpServletResponse resp) throws Exception {
		 User user=new User();
         user.setAccounts(name);
	     boolean b = service.selectUser(user);
	     resp.getWriter().write(b+""); 	
	}
	/**
	 * @admin���������˺���֤
	 */
	@RequestMapping("jsp/loginjudge1")
	public void  loginjudge1(String name,HttpServletRequest req,HttpServletResponse resp) throws Exception {
		 //��ĵ�nameΪaccounts
		 boolean b = adminservice.selectaccounts(name);
	     resp.getWriter().write(b+""); 	
	}
	/**
	 * @�����ajax��֤
	 */
	@RequestMapping("/pwdjudge")
	public void  pwdjudge(String name1,String name2,HttpServletRequest req,HttpServletResponse resp) throws Exception {
         User user=new User();
         user.setPassword(name1);
         user.setAccounts(name2);
         System.out.println(user);
	     boolean b = service.selectUser(user);
	     resp.getWriter().write(b+""); 	
	}
	/**
	 * @admin����������ҳ��������֤
	 */
	@RequestMapping("jsp/pwdjudge1")
	public void  pwdjudge1(String accounts,String pwd,HttpServletRequest req,HttpServletResponse resp) throws Exception {
		boolean b = adminservice.select(accounts, pwd, req);
		resp.getWriter().write(b+""); 	
	}
	/**
	 * @ע��������˺�Ajax��֤
	 */
	@RequestMapping("/validateEmail")
	public void  validateEmail(String name,HttpServletRequest req,HttpServletResponse resp) throws Exception {
		User user=new User();
        user.setAccounts(name);
	    boolean b = service.selectUser(user);
	    resp.getWriter().write(b+""); 	
	}
	
	/**
	 * @�޸�����
	 */
	@RequestMapping("/jsp/loginjudge")
	public void  jsploginjudge(String name,HttpServletRequest req,HttpServletResponse resp) throws Exception {
		 User user=new User();
         user.setAccounts(name);
	     boolean b = service.selectUser(user);
	     resp.getWriter().write(b+""); 	
	}
	
	@RequestMapping("/jsp/pwdjudge")
	public void  jsppwdjudge(String name1,String name2,HttpServletRequest req,HttpServletResponse resp) throws Exception {
         User user=new User();
         user.setPassword(name1);
         user.setAccounts(name2);
         System.out.println(user);
	     boolean b = service.selectUser(user);
	     resp.getWriter().write(b+""); 	
	}

}
