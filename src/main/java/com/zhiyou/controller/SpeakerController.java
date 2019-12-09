package com.zhiyou.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou.model.Speaker;
import com.zhiyou.service.SpeakerService;
import com.zhiyou.util.FtpUtil;

@Controller
public class SpeakerController {
	@Autowired
	SpeakerService Spservice;
	
	@RequestMapping("/SpeakerSelect")
	public String selectAll(HttpServletRequest request,HttpServletResponse resp) {
		String speaker_name = request.getParameter("speaker_name")==null?"":request.getParameter("speaker_name");
		int count = Spservice.selectCount(speaker_name);
		System.out.println(count);
		int page=request.getParameter("page")==null||request.getParameter("page")==""? 1:Integer.valueOf(request.getParameter("page"));
		request.setAttribute("page", page);
		request.setAttribute("count", count);
		List<Speaker> list = Spservice.selectAll((page-1)*5,5,speaker_name);
		request.setAttribute("speaker_name", speaker_name);
		request.setAttribute("list", list);
		return "/speaker";
	}
	@RequestMapping("/deleteSpeaker")
	public void delete(Integer id,HttpServletRequest req,HttpServletResponse resp) {
		Spservice.delete(id,resp);
	}
	@RequestMapping("/insertSpeaker")
	public String add(Speaker speaker,MultipartFile url,   HttpServletRequest req,HttpServletResponse resp) throws IOException {
		String upload = FtpUtil.upload(url.getInputStream(), url.getOriginalFilename());
		speaker.setPic_url(upload);
		
		Spservice.add(speaker);
		return "redirect:SpeakerSelect";
	}
	@RequestMapping("/updateSpeaker")
	public String update(Speaker speaker,HttpServletRequest req,HttpServletResponse resp) {
		System.out.println(speaker);
		Spservice.update(speaker);
		return "redirect:SpeakerSelect";
	}
	@RequestMapping("/updateSpeakerSelectByID")
	public String selectById(HttpServletRequest req,HttpServletResponse resp) {
		Integer id =Integer.valueOf(req.getParameter("id"));
		Speaker speaker = Spservice.selectByID(id);
		req.setAttribute("list", speaker);
		return "/updateSpeaker";
	}
	@RequestMapping("/delAllSpeaker")
	public void deleteUser(@RequestParam("userIds[]") Integer[] userIds ,HttpServletResponse resp){
			List<Integer> userIdList = Arrays.asList(userIds);
			System.out.println(userIdList);
			Spservice.removeCourse(userIdList, resp);
		
}

}
