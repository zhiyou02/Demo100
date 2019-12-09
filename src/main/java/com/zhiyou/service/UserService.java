package com.zhiyou.service;

import javax.servlet.http.HttpServletRequest;

import com.zhiyou.model.User;

public interface UserService {
	User loginSelect(HttpServletRequest req,String accounts,String password);
	User selectByAccounts(String accounts);
	User selectByID(Integer id);
	void add(User user);
	void update(User user);
	boolean selectUser(User user);

}
