package com.zhangyingwei.miner.rssclient.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhangyingwei.miner.common.util.TokenUtil;
import com.zhangyingwei.miner.rssclient.controller.base.BaseController;
import com.zhangyingwei.miner.rssclient.entity.User;
import com.zhangyingwei.miner.rssclient.service.UserService;
import com.zhangyingwei.simpleutils.util.UtilFactory;

@Controller
@RequestMapping
public class LoginController extends BaseController{
	
	@Resource
	private UserService userService;
	
	@InitBinder("user")
	public void InitBinderUser(WebDataBinder binder){
		binder.setFieldDefaultPrefix("user.");
	}
	
	@RequestMapping("/mainshow.do")
	public ModelAndView mainShow(){
		return new ModelAndView("main_wel/main_index");
	}

	@RequestMapping("/logout.do")
	public void logout(HttpSession session,HttpServletResponse response){
		session.removeAttribute("logonuser");
		session.removeAttribute(TokenUtil.TOKEN_KEY);
		session.removeAttribute(TokenUtil.TOKEN_STATU);
		try {
			response.sendRedirect("/miner/");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/miner.do")
	public ModelAndView toIndex(@ModelAttribute User user,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		Cookie[] cookies = request.getCookies();
		if(cookies!=null&&cookies.length!=0){
			//cookielogin
			if(this.cookieLogin(request, session)){
				return new ModelAndView("/main_wel/main_wel");
			}
		}
		if(!user.isNull()){
			if(this.mainLogin(user, session)){
				return new ModelAndView("/main_wel/main_wel");
			}else{
				return new ModelAndView("index",super.getResultData().put("message", "登录失败，请稍后再试"));
			}
		}
		//dufaultlogin
		return new ModelAndView("index");
	}
	
	
	//default login
	private boolean mainLogin(User user,HttpSession session){
		boolean isSucc = false;
		try {
			if(this.userService.login(user,session)){
				session.setAttribute(TokenUtil.TOKEN_KEY, TokenUtil.getToken());
				User userinfo = (User) session.getAttribute("logonuser");
				if(userinfo!=null){
					super.addCookie("UNAME", userinfo.getUsername());
					super.addCookie("PWD", userinfo.getPasswd());
				}
				isSucc = true;
			}
		} catch (Exception e) {
			isSucc = false;
		}
		return isSucc;
	}
	
	//login by cookie
	private boolean cookieLogin(HttpServletRequest request,HttpSession session){
		boolean isSucc = false;
		Cookie[] cookies = request.getCookies();
		if(cookies==null||cookies.length==0){
			isSucc = false;
			return isSucc;
		}
		String username = super.getCookieValue(cookies, "UNAME");
		String passwd = super.getCookieValue(cookies, "PWD");
		User user = new User();
		user.setUsername(username);
		user.setPasswd(passwd);
		if(this.mainLogin(user, session)){
			isSucc = true;
		}
		return isSucc;
	}
	
}
