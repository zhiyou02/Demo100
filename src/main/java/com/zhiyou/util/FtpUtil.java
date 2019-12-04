package com.zhiyou.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;


import org.apache.commons.net.ftp.FTPClient;


public class FtpUtil {
	
	public static String upload(InputStream input,String filename) {
		filename=System.currentTimeMillis()+filename;
		
		
		FTPClient ftp = new FTPClient();
		String url="ftp://192.168.124.60/";
		
		
		try {
			ftp.connect("192.168.124.60");
			ftp.login("admin", "123");
			ftp.enterLocalPassiveMode();
			ftp.changeWorkingDirectory("/");
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftp.storeFile(filename, input);
			return url+filename;
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ftp.logout();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
}
