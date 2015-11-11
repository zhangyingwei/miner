package com.zhangyingwei.miner.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.zhangyingwei.miner.common.dao.ArticleDao;
import com.zhangyingwei.miner.common.entity.Article;
import com.zhangyingwei.miner.common.util.DateUtil;
import com.zhangyingwei.model.RssEntity;
import com.zhangyingwei.model.RssHead;
import com.zhangyingwei.model.RssModel;
import com.zhangyingwei.miner.server.factory.BeanFactory;

@Controller
public class SArticleController {
	
	@Autowired
	private ArticleDao articleDao;
	
	public void saveArticle(RssHead rssHead,RssEntity rssEntity){
		Article article = Article.buildArticle(rssHead, rssEntity);
		this.articleDao.saveArticle(article);
	}
	
	//判断是不是新文章
	public boolean isNewArticle(Article article){
		if(article==null){
			return false;
		}else{
			Article article_old = this.articleDao.queryArticleByPar(article);
			if(article_old==null){
				return true;
			}
			if(DateUtil.equals(article.getSupdated(), article_old.getSupdated())){
				return false;
			}else if(DateUtil.equals(article.getEpublished(), article_old.getEpublished())){
				return false;
			}
			return true;
		}
	}
	//判断是不是新文章
	public boolean isNewArticle(RssHead rssHead,RssEntity rssEntity){
		Article article = Article.buildArticle(rssHead, rssEntity);
		return this.isNewArticle(article);
	}
	
	
}
