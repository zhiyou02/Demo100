package com.zhiyou.service.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhiyou.mapper.VideoMapper;
import com.zhiyou.model.Speaker;
import com.zhiyou.model.Subject;
import com.zhiyou.model.Video;
import com.zhiyou.service.VideoService;

@Service
public class VideoServiceImpl implements VideoService{
	
	@Autowired
	VideoMapper mapper;
	
	@Transactional
	
	public void add(Video video) {
		mapper.add(video);
		
	}

	public void update(Video video) {
		mapper.update(video);
		
	}

	public void delete(Integer id, HttpServletResponse resp) {
		int number = mapper.delete(id);
		if (number==1) {
			try {
				resp.getWriter().write("success");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	public List<Video> selectAll(int page, int number, String title) {
		
		return mapper.selectAll(page, number, title);
	}

	public Video selectByID(Integer video_id) {
		
		return mapper.selectByID(video_id);
	}

	public Video selectByVideoid(int video_id) {
		
		return mapper.selectByVideoid(video_id);
	}

	public List<Subject> selectSubject() {
		
		return mapper.selectSubject();
	}

	public List<Speaker> selectSpeaker() {
		
		return mapper.selectSpeaker();
	}

	public Subject selectSubjectByName(String subject_name) {
		
		return mapper.selectSubjectByName(subject_name);
	}

	public Speaker selectSpeakerByName(String speaker_name) {
		
		return mapper.selectSpeakerByName(speaker_name);
	}

	public int selectCount(String title) {
		
		return mapper.selectCount(title);
	}

	public void removeCourse(List<Integer> userIdList, HttpServletResponse resp) {
		int i = mapper.removeCourse(userIdList);
		if (i==userIdList.size()) {
			try {
				resp.getWriter().write("success");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}


	public List<Video> selectVideoUrl(Integer video_id) {
		
		return mapper.selectVideoUrl(video_id);
	}

	public List<Video> selectAlls(Integer id) {
		
		return mapper.selectAlls(id);
	}
}
