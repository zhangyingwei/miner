package com.zhangyingwei.miner.common.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.springframework.core.io.ClassPathResource;

public class PropertielUtil {

	private static Properties instanceProperties = null;
	
	public static Properties loadProperties(String name){
		Properties properties = new Properties();
		try {
			InputStream input = new FileInputStream(new ClassPathResource(name).getFile());
			properties.load(input);
		} catch (FileNotFoundException e) {
			System.out.println("@FileNotFoundException:"+e);
		} catch (IOException e) {
			System.out.println("@IOException"+e);
		}
		return properties;
	}
	
	public static Properties loadMailProperties(){
		if(instanceProperties==null){
			instanceProperties = loadProperties("mail.properties");
		}
		return instanceProperties;
	}
}
