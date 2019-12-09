package com.zhiyou.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
	 Integer id;
	 String course_title;
	 String course_desc;
	 Integer subject_id;
	
	//学科的少的一份
	Subject subject;
	//视频的多的一方
	List<Video> videos;
	
}
