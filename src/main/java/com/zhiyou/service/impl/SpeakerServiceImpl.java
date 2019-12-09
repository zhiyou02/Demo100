package com.zhiyou.service.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhiyou.mapper.SpeakerMapper;
import com.zhiyou.model.Speaker;
import com.zhiyou.service.SpeakerService;
@Service
public class SpeakerServiceImpl implements SpeakerService{
	
	@Autowired
	SpeakerMapper mapper;
	
	@Transactional

	public void add(Speaker speaker) {
		mapper.add(speaker);
		
	}

	public void update(Speaker speaker) {
		mapper.update(speaker);
		
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

	public List<Speaker> selectAll(int page, int number, String speaker_name) {
		
		return mapper.selectAll(page, number, speaker_name);
	}

	public Speaker selectByID(Integer id) {
		
		return mapper.selectByID(id);
	}

	public Speaker selectBySpeakerid(int id) {
		
		return mapper.selectBySpeakerid(id);
	}

	public int selectCount(String speaker_name) {
		
		return mapper.selectCount(speaker_name);
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





}
