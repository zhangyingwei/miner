package com.zhangyingwei.miner.rssclient.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.zhangyingwei.miner.rssclient.controller.base.BaseController;
import com.zhangyingwei.miner.rssclient.entity.User;
import com.zhangyingwei.miner.rssclient.service.UserService;

@Controller
@RequestMapping
public class LoginController extends BaseController{
	
	@Resource
	private UserService userService;
	
	@InitBinder("user")
	public void InitBinderUser(WebDataBinder binder){
		binder.setFieldDefaultPrefix("user.");
	}
	
	@RequestMapping("/login.do")
	public ModelAndView login(@ModelAttribute User user,HttpSession session,Model model){
		try {
			if(this.userService.login(user,session)){
				model.addAttribute("user","hello");
				return new ModelAndView("/main_wel/main_wel");
			}
		} catch (Exception e) {
		}
		return new ModelAndView("index",super.getResultData().put("message", "登录失败，请稍后再试"));
	}
	
	@RequestMapping("/mainshow.do")
	public ModelAndView mainShow(){
		return new ModelAndView("main_wel/main_index");
	}
	
	
}
