package com.zhangyingwei.miner.rssclient.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangyingwei.miner.common.util.ServiceReturn;
import com.zhangyingwei.miner.common.entity.PageInfo;
import com.zhangyingwei.miner.common.dao.ArticleDao;
import com.zhangyingwei.miner.common.entity.Article;

@Service
public class ArticleService {
	
	@Autowired
	private ArticleDao articleDao;
	
	public ServiceReturn findAll(PageInfo pageinfo){
		List<Article> articles = new ArrayList<Article>();
		articles = this.articleDao.queryArticle(pageinfo);
		pageinfo.setTotal(this.articleDao.getCount());
		return new ServiceReturn().setResultList(articles).setPageInfo(pageinfo);
	}
	
	public void delete(String elink){
		this.articleDao.deleteArticle(elink);
	}
}
