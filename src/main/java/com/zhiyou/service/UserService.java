package com.zhiyou.service;

import com.zhiyou.model.User;

public interface UserService {
	User selectByAccounts(String accounts);
	User selectByID(int id);
	void add(User user);
	void update(User user);

}
