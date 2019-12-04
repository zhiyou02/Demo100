package com.zhiyou.model;

import java.util.Date;

public class User {
	private Integer id;
	private String accounts;
	private String phone;
	private String password;
	private String nickname;
	private String sex;
	private String birthday;
	private String address;
	private String imgurl;
	private Date createtime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccounts() {
		return accounts;
	}
	public void setAccounts(String accounts) {
		this.accounts = accounts;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", accounts=" + accounts + ", phone=" + phone + ", password=" + password
				+ ", nickname=" + nickname + ", sex=" + sex + ", birthday=" + birthday + ", address=" + address
				+ ", imgurl=" + imgurl + ", createtime=" + createtime + "]";
	}
	public User(Integer id, String accounts, String phone, String password, String nickname, String sex,
			String birthday, String address, String imgurl, Date createtime) {
		
		this.id = id;
		this.accounts = accounts;
		this.phone = phone;
		this.password = password;
		this.nickname = nickname;
		this.sex = sex;
		this.birthday = birthday;
		this.address = address;
		this.imgurl = imgurl;
		this.createtime = createtime;
	}
	public User() {
	
	}
	public User(String accounts, String phone, String password, String nickname, String sex, String birthday,
			String address, String imgurl, Date createtime) {
		
		this.accounts = accounts;
		this.phone = phone;
		this.password = password;
		this.nickname = nickname;
		this.sex = sex;
		this.birthday = birthday;
		this.address = address;
		this.imgurl = imgurl;
		this.createtime = createtime;
	}
	
	

}
