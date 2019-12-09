package com.zhiyou.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
	 Integer admin_id;
	 String accounts;
	 String password;
	 String admin_remark;	
}
