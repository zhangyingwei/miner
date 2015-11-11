package com.zhangyingwei.miner.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {
	
	public static Date dateFormat(String dateStr){
		try {
			return new SimpleDateFormat().parse(dateStr);
		} catch (ParseException e) {
			System.out.println(e);
		}
		return null;
	}
	
	public static boolean equals(String c1,String c2){
//		return equals(dateFormat(c1),dateFormat(c2));
		if(c1==null){
			return false;
		}else if(c2==null){
			return false;
		}else if(c1.equals(c2)){
			return true;
		}
		return false;
	}
	
	public static boolean equals(Date c1,Date c2){
		if(c1==null){
			return false;
		}else if(c2==null){
			return false;
		}else if(c1.equals(c2)){
			return true;
		}
		return false;
	}
}
