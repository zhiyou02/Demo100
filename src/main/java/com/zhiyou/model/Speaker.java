package com.zhiyou.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Speaker {
	 Integer id;
	 String speaker_name;
	 String speaker_desc;
	 String speaker_job;
	 String pic_url;
	
}
