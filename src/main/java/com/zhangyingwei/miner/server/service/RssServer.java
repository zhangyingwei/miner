package com.zhangyingwei.miner.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhangyingwei.miner.common.entity.Article;
import com.zhangyingwei.miner.common.util.MailUtil;
import com.zhangyingwei.miner.server.action.SArticleHandler;

@Component
public class RssServer {
	
	public static final Integer SERVER_AUTORUN = 0;
	public static final Integer SERVER_NORUN = 1;
	
	@Autowired
	private SArticleHandler articleHandler;
	
	public void doRss(){
		List<Article> articles = articleHandler.doArticle();
		MailUtil.sendNoticeMail(articles);
	}
}
