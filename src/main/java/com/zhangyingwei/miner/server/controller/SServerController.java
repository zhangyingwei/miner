package com.zhangyingwei.miner.server.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zhangyingwei.miner.rssclient.controller.base.BaseController;
import com.zhangyingwei.miner.common.util.ResultData;
import com.zhangyingwei.miner.server.factory.BeanFactory;

@Controller
//@RequestMapping("/server")
public class SServerController extends BaseController{
	
	
	//@RequestMapping("/start.do")
	public ModelAndView ServerStart(){
		try {
			BeanFactory.getServerStarter().serverRun();
			return new ModelAndView("server/serverstuts",super.getResultData().put("message", "启动成功,欢迎使用本系统！！！"));
		} catch (Exception e) {
			return new ModelAndView("server/serverstuts",super.getResultData().put("message", "启动失败..."+e));
		}
	}
	
	//@RequestMapping("/stop.do")
	public ModelAndView ServerStop(){
		try {
			BeanFactory.getServerStarter().serverStop();
			return new ModelAndView("server/serverstuts",super.getResultData().put("message", "关闭成功,期待下次使用本系统！！！"));
		} catch (Exception e) {
			return new ModelAndView("server/serverstuts",super.getResultData().put("message", "关闭失败..."+e));
		}
	}
	
	
}
