package com.zhiyou.mapper;

import java.util.List;

import com.zhiyou.model.User;

public interface UserMapper {
	User selectByAccounts(String accounts);
	User selectByID(Integer id);
	void add(User user);
	void update(User user);
	List<User> selectUser(User user);

}
