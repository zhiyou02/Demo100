package com.zhiyou.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhiyou.model.Speaker;

public interface SpeakerMapper {
	void add(Speaker speaker); 
	void update(Speaker speaker);    
	int  delete(Integer id);
	List<Speaker> selectAll(int page,int number,String speaker_name);    
	Speaker selectByID(Integer id);
	
	Speaker selectBySpeakerid(int id);
	int selectCount(String speaker_name);
	int removeCourse(@Param("userIdList")List<Integer> userIdList);

}
