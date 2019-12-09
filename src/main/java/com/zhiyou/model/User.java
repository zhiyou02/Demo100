package com.zhiyou.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	 Integer id;
	 String accounts;
	 String phone;
	 String password;
	 String nickname;
	 String sex;
	 String birthday;
	 String address;
	 String imgurl;
	 Date createtime;
	
	
	

}
