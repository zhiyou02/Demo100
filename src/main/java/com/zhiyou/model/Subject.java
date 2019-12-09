package com.zhiyou.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
	private Integer subject_id;
	private String subject_name;
	//ѧ�ƶԿγ���˵�Ƕ��һ��
	private List<Course> courses;
	
}
