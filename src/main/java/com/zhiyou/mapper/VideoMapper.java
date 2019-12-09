package com.zhiyou.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhiyou.model.Speaker;
import com.zhiyou.model.Subject;
import com.zhiyou.model.Video;

public interface VideoMapper {
	void add(Video video); 
	void update(Video video);    
	int delete(Integer id);
	List<Video> selectAll(int page,int number,String title);    
	Video selectByID(Integer video_id);
	
	Video selectByVideoid(int video_id);
	List<Subject> selectSubject();
	List<Speaker> selectSpeaker();
	Subject selectSubjectByName(String subject_name);
	Speaker selectSpeakerByName(String speaker_name);
	int selectCount(String title);
	int removeCourse(@Param("userIdList")List<Integer> userIdList);
	
	List<Video> selectVideoUrl(Integer video_id);
	
	List<Video> selectAlls(Integer id);

}
