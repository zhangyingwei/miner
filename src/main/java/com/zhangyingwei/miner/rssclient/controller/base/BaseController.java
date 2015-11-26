package com.zhangyingwei.miner.rssclient.controller.base;


import java.io.IOException;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.zhangyingwei.miner.common.util.ResultData;
import com.zhangyingwei.simpleutils.encode.DESUtil;
import com.zhangyingwei.simpleutils.util.UtilFactory;

public class BaseController {
	
	private Logger logger = Logger.getLogger(BaseController.class);
	private static final String ENCODEKEY = "zhangyingwei.com";//encode base key
	
	protected ResultData getResultData(){
		return new ResultData();
	}
	
	@Autowired(required=false)
	HttpServletResponse response;
	
	@Autowired(required=false)
	HttpServletRequest request;
	
	protected void setResultMsg(String message){
		try {
			this.response.setCharacterEncoding("utf-8");
			this.response.getWriter().print(message);
			this.response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	protected void setResultMsg(Map message){
		try {
			this.response.setCharacterEncoding("utf-8");
			this.response.getWriter().print(JSONObject.fromObject(message).toString());
			this.response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void addCookie(String key,String value){
		String encodevalue = "";
		try {
			encodevalue = UtilFactory.getEncodeUtil().encodeDES(value, ENCODEKEY);
		} catch (Exception e) {
//			e.printStackTrace();
		}
		Cookie cookie = new Cookie(key, encodevalue);
		//cookie`s age is one month
		cookie.setMaxAge(1000*60*60*24*15);
		response.addCookie(cookie);
		logger.debug("@addCookie:");
		logger.debug(cookie.getName()+":"+cookie.getValue());
	}
	
	
	protected String getCookieValue(Cookie[] cookies,String name){
		for(Cookie c:cookies){
			try {
				if(c.getName()!=null&&c.getName().equals(name)){
					logger.debug("@readCookie:");
					logger.debug(name+":"+UtilFactory.getEncodeUtil().decodeDES(c.getValue(), ENCODEKEY));
					return UtilFactory.getEncodeUtil().decodeDES(c.getValue(), ENCODEKEY);
				}
			} catch (Exception e) {
//				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
	
}
