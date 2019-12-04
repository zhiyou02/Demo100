package com.zhiyou.mapper;

import com.zhiyou.model.User;

public interface UserMapper {
	User selectByAccounts(String accounts);
	User selectByID(int id);
	void add(User user);
	void update(User user);

}
