package com.zhiyou.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.zhiyou.model.Speaker;
import com.zhiyou.model.Subject;
import com.zhiyou.model.Video;

public interface VideoService {
	void add(Video video); 
	void update(Video video);    
	void delete(Integer id,HttpServletResponse resp);
	List<Video> selectAll(int page,int number,String title);    
	Video selectByID(Integer video_id);
	
	Video selectByVideoid(int video_id);
	List<Subject> selectSubject();
	List<Speaker> selectSpeaker();
	Subject selectSubjectByName(String subject_name);
	Speaker selectSpeakerByName(String speaker_name);
	int selectCount(String title);
	void removeCourse(List<Integer> userIdList,HttpServletResponse resp);
	
	List<Video> selectVideoUrl(Integer video_id);
	
	List<Video> selectAlls(Integer id);

}
