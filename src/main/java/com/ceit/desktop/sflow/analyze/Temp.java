package com.ceit.desktop.sflow.analyze;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Temp {
	public static void main(String[] args) throws IOException {
		InputStream in = new BufferedInputStream(
				new FileInputStream("./conf/sflow.properties"));
		Properties pro = new Properties();
		pro.load(in);
		in.close();
		System.out.println(pro.getProperty("redis_ip"));
		
	}



}
