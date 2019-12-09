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
	
	//ѧ�Ƶ��ٵ�һ��
	Subject subject;
	//��Ƶ�Ķ��һ��
	List<Video> videos;
	
}
