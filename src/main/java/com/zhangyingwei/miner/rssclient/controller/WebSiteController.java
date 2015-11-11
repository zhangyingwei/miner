package com.zhangyingwei.miner.rssclient.controller;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.zhangyingwei.miner.common.util.ServiceReturn;
import com.zhangyingwei.miner.rssclient.controller.base.BaseController;
import com.zhangyingwei.miner.common.entity.PageInfo;
import com.zhangyingwei.miner.rssclient.entity.WebSite;
import com.zhangyingwei.miner.rssclient.service.WebSiteService;
import com.zhangyingwei.miner.common.util.ResultData;
import com.zhangyingwei.miner.common.util.WebSiteUtil;
import com.zhangyingwei.handler.RssHandler;

@Controller
public class WebSiteController extends BaseController{
	
	@Autowired
	private WebSiteService webSiteService;
	
	@RequestMapping("weblist.do")
	public ModelAndView webList(String currentPage){
		PageInfo pageInfo = PageInfo.getPageInfo(currentPage);
		ServiceReturn serviceReturn = this.webSiteService.queryAll(pageInfo);
		return new ModelAndView("website/weblist",super.getResultData().put("websites", serviceReturn.getResultList()).put("pageinfo", serviceReturn.getPageInfo()));
	}
	
	@RequestMapping("webadd.do")
	@ResponseBody
	public void webSiteAdd(String data){
		ResultData resultData = super.getResultData();
		String result = "";
		try {
			if(this.webSiteService.isHas(data)){
				resultData.put(ResultData.MESSAGE, "地址已存在");
				result = JSONObject.fromObject(resultData).toString();
			}else{
				;
				this.webSiteService.add(WebSiteUtil.buildWebSite(data).setWebsitelink(data));
				resultData.put(ResultData.MESSAGE, "添加成功");
				result = JSONObject.fromObject(resultData).toString();
			}
		} catch (Exception e) {
			resultData.put(ResultData.MESSAGE, "地址识别有误");
			result = JSONObject.fromObject(resultData).toString();
		}
		super.setResultMsg(result);
	}
	
	@RequestMapping("webdel.do")
	@ResponseBody
	public void webSiteDel(String website){
		Map resultData = super.getResultData();
		if(website==null||website.length()==0){
			resultData.put(ResultData.MESSAGE, "删除项不可为空");
		}else if(this.webSiteService.isHas(website)){
			this.webSiteService.delete(website);
			resultData.put(ResultData.MESSAGE, "删除成功");
		}else{
			resultData.put(ResultData.MESSAGE, "不存在");
		}
		super.setResultMsg(resultData);
	}
}
