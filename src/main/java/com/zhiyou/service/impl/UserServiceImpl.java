package com.zhiyou.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhiyou.mapper.UserMapper;
import com.zhiyou.model.User;
import com.zhiyou.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	
	
	@Autowired
	UserMapper mapper;
	
	@Transactional

	public User selectByID(Integer id) {
		
		return mapper.selectByID(id);
	}

	public User selectByAccounts(String accounts) {
		User user = mapper.selectByAccounts(accounts);
		if (user!=null) {
			return user;
		}else {
			return null;
		}
		
	}

	public void add(User user) {
		mapper.add(user);
		
	}

	public void update(User user) {
		mapper.update(user);
		
	}

	public User loginSelect(HttpServletRequest req, String accounts, String password) {
		User user = mapper.selectByAccounts(accounts);
		if (user!=null) {
			if (user.getPassword().equals(password)) {
			}else {
				req.setAttribute("msg", "√‹¬Î¥ÌŒÛ,«Î÷ÿ–¬ ‰»Î");
			}
		}else {
			req.setAttribute("msg", "’À∫≈≤ª¥Ê‘⁄£¨«Î◊¢≤·");
		}
		return user;
	}

	public boolean selectUser(User user) {
		List<User> list = mapper.selectUser(user);
		if (list.size()!=0) {
			return true;
		}else {
			return false;
		}
	}

}
