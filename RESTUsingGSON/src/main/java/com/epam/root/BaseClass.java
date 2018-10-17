package com.epam.root;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
	//base variables 
	public static Properties pros;
	public static int Res_code_200 = 200;
	public static int Res_code_201 = 201;
	public static int Res_code_404 = 404;
	
	public static Properties getDefaultConfig() {
		pros =new Properties();
		try {
			pros.load(new FileInputStream(System.getProperty("user.dir")+"\\config.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pros;
	}	
}
