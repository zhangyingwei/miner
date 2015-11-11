package com.zhangyingwei.miner.wxclient.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhangyingwei.entity.WXInfo;
import com.zhangyingwei.handler.WXHandler;
import com.zhangyingwei.miner.common.util.ResultData;
import com.zhangyingwei.miner.common.util.ServiceReturn;
import com.zhangyingwei.miner.common.entity.PageInfo;
import com.zhangyingwei.miner.wxclient.common.WXInfoPool;
import com.zhangyingwei.miner.wxclient.controller.base.BaseController;
import com.zhangyingwei.miner.wxclient.service.WXSiteService;

@Controller
public class WXSiteController extends BaseController{
	
	@Autowired
	private WXSiteService wxSiteService;
	
	@RequestMapping("wxweblist.do")
	public ModelAndView toWxList(String currentPage){
		PageInfo pageInfo = PageInfo.getPageInfo(currentPage);
		ServiceReturn serviceReturn = this.wxSiteService.findByPage(pageInfo);
		return new ModelAndView("wxsite/wxweblist",super.getResultData().put("pageinfo", serviceReturn.getPageInfo()).put("wxsiteinfos", serviceReturn.getResultList()));
	}
	
	@RequestMapping("searchwxsite.do")
	@ResponseBody
	public ModelAndView queryWxSiteFromWeb(String wxname){
		if(wxname==null||wxname.trim().length()==0){
			return new ModelAndView("wxsite/wxinfolist", super.getResultData().put("wxinfos", new ArrayList()));
		}
		List<WXInfo> wxInfos =  WXHandler.getWxInfo(wxname);
		//place to save weixin information
		WXInfoPool.getInstance().setWXInfos(wxInfos);
		return new ModelAndView("wxsite/wxinfolist", super.getResultData().put("wxinfos", wxInfos));
	}
	
	@RequestMapping("savewxsite.do")
	@ResponseBody
	public void saveWxSiteInfo(String wxname){
		try {
			this.wxSiteService.saveWxInfo(wxname);
		} catch (Exception e) {
			super.setResultMsg("error");
			e.printStackTrace();
			return;
		}
		super.setResultMsg("success");
	}
	
	@RequestMapping("delwxsite.do")
	@ResponseBody
	public void delWxSiteInfo(String wxsiteid){
		try {
			this.wxSiteService.deleteWxSiteInfo(wxsiteid);
		} catch (Exception e) {
			super.setResultMsg(super.getResultData().put("message", "error"));
		}
		super.setResultMsg(super.getResultData().put("message", "success"));
	}
}
