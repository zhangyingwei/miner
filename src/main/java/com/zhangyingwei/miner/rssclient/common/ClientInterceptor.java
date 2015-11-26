package com.zhangyingwei.miner.rssclient.common;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zhangyingwei.miner.common.util.TokenUtil;

public class ClientInterceptor implements HandlerInterceptor{

	Logger logger = Logger.getLogger(ClientInterceptor.class);
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
		logger.debug("afterCompletion");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView model) throws Exception {
		logger.debug("postHandle");
		if(!TokenUtil.TOKEN_STATU_T.equals(request.getAttribute(TokenUtil.TOKEN_STATU))){
			model.setViewName("/err/nologin");
		}
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		logger.debug("@preHandle");
		String token = request.getParameter(TokenUtil.TOKEN_KEY);
		String path = request.getRequestURI();
		if(path!=null&&path.endsWith("login.do")){
			request.setAttribute(TokenUtil.TOKEN_STATU, TokenUtil.TOKEN_STATU_T);
		}else if(path.endsWith("logout.do")){
			request.setAttribute(TokenUtil.TOKEN_STATU, TokenUtil.TOKEN_STATU_T);
		}else if(path.endsWith("miner.do")){
			request.setAttribute(TokenUtil.TOKEN_STATU, TokenUtil.TOKEN_STATU_T);
		}else{
			if(TokenUtil.isHave(request, token)){
				request.setAttribute(TokenUtil.TOKEN_STATU, TokenUtil.TOKEN_STATU_T);
			}else{
				request.setAttribute(TokenUtil.TOKEN_STATU, TokenUtil.TOKEN_STATU_F);
			}
		}
		return true;
	}
	
}
