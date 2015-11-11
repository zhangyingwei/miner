package com.zhangyingwei.miner.wxclient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zhangyingwei.miner.common.entity.PageInfo;
import com.zhangyingwei.miner.common.util.ServiceReturn;
import com.zhangyingwei.miner.wxclient.controller.base.BaseController;
import com.zhangyingwei.miner.wxclient.entity.WXMessageInfo;
import com.zhangyingwei.miner.wxclient.service.WXMessageService;

@Controller
public class WXArticleController extends BaseController{
	
	@Autowired
	private WXMessageService wxMessageService;
	
	@RequestMapping("wxmessagelist.do")
	public ModelAndView queryByPage(String currentPage){
		ServiceReturn sReturn = this.wxMessageService.queryByPage(new PageInfo().getPageInfo(currentPage));
		return new ModelAndView("wxsite/wxmessageinfolist", super.getResultData().put("wxMessageInfos", sReturn.getResultList()).put("pageinfo", sReturn.getPageInfo()));
	}
}
