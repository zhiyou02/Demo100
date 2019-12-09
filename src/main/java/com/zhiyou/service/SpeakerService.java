package com.zhiyou.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.zhiyou.model.Speaker;

public interface SpeakerService {
	void add(Speaker speaker); 
	void update(Speaker speaker);    
	void delete(Integer id,HttpServletResponse resp);
	List<Speaker> selectAll(int page,int number,String speaker_name);    
	Speaker selectByID(Integer id);
	
	Speaker selectBySpeakerid(int id);
	int selectCount(String speaker_name);
	void removeCourse(List<Integer> userIdList,HttpServletResponse resp);

}
