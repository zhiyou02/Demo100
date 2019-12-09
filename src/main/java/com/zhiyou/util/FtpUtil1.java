package com.zhiyou.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

public class FtpUtil1 {
	
public static String upload(MultipartFile filename,HttpServletRequest req,HttpServletResponse resp) throws IOException {
			

			
			InputStream input = filename.getInputStream();
			
		    String name="G:/"+System.currentTimeMillis()+filename.getOriginalFilename();
		
		    OutputStream output = new FileOutputStream(name);

		    IOUtils.copy(input, output);
		    
		    System.out.println("需要存放到数据库的是文件名称和文件路径");
	        input.close();
	        output.close();
			return name;
		}
	}
	

