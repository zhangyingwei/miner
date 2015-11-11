package com.zhangyingwei.miner.rssclient.controller;

import java.util.List;

import net.sf.json.JSONObject;

import org.apache.ibatis.annotations.Arg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhangyingwei.miner.rssclient.controller.base.BaseController;
import com.zhangyingwei.miner.common.entity.PageInfo;
import com.zhangyingwei.miner.rssclient.service.ArticleService;
import com.zhangyingwei.miner.common.entity.Article;
import com.zhangyingwei.miner.common.util.ResultData;
import com.zhangyingwei.miner.common.util.ServiceReturn;

@Controller
public class ArticeController extends BaseController{
	
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("articlelist.do")
	public ModelAndView listArtice(String currentPage){
		PageInfo pageInfo = PageInfo.getPageInfo(currentPage);
		System.out.println(pageInfo);
//		List<Article> articles = 
		ServiceReturn sReturn = this.articleService.findAll(pageInfo);
		return new ModelAndView("notice/articenotice",super.getResultData().put("articles", sReturn.getResultList()).put("pageinfo", sReturn.getPageInfo()));
	}
	
	@RequestMapping("articledel.do")
	@ResponseBody
	public void deleteArticle(String elink){
		ResultData result = super.getResultData();
		try {
			this.articleService.delete(elink);
			result.put(ResultData.MESSAGE, "成功");
		} catch (Exception e) {
			result.put(ResultData.MESSAGE, "失败");
		}
		super.setResultMsg(JSONObject.fromObject(result).toString());
	}
}
