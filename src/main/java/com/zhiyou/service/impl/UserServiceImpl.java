package com.zhiyou.service.impl;

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

	public User selectByID(int id) {
		
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

}
