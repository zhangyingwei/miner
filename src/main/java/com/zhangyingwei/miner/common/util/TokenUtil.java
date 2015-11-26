package com.zhangyingwei.miner.common.util;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import com.zhangyingwei.simpleutils.encode.MD5Util;
import com.zhangyingwei.simpleutils.util.UtilFactory;

public class TokenUtil {
	
	public static final String TOKEN_KEY = "token";
	public static final String TOKEN_STATU = "token_statu";
	public static final Integer TOKEN_STATU_T = 0;
	public static final Integer TOKEN_STATU_F = 1;
	
	public static String getToken(){
		Integer base = new Random().nextInt();
		return MD5Util.getInstance().getMD5ofStr(base.toString());
	}
	
	public static boolean isHave(HttpServletRequest request,String token){
		if(UtilFactory.getStringUtil().isNull(token)){
			return false;
		}else if(UtilFactory.getStringUtil().isNull((String) request.getSession().getAttribute(TOKEN_KEY))){
			return false;
		}else if(request.getSession().getAttribute(TOKEN_KEY).equals(token)){
			return true;
		}else{
			return false;
		}
	}
}
