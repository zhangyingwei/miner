package com.zhangyingwei.miner.server.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhangyingwei.miner.rssclient.entity.WebSite;
import com.zhangyingwei.miner.common.entity.Article;
import com.zhangyingwei.handler.RssHandler;
import com.zhangyingwei.model.RssEntity;
import com.zhangyingwei.model.RssHead;
import com.zhangyingwei.model.RssModel;
import com.zhangyingwei.miner.server.controller.SArticleController;
import com.zhangyingwei.miner.server.controller.SWebSiteController;
import com.zhangyingwei.miner.server.factory.BeanFactory;

@Component
public class ArticleHandler {
	
	@Autowired
	private SWebSiteController siteController;
	@Autowired
	private SArticleController articleController;
	
	private ArticleHandler(){
	}
	
	//文章获取&&比对
	public List doArticle(){
		List<WebSite> webSites =  this.siteController.queryAllWebSites();
		List<Article> newArticle = new ArrayList<Article>();
		for(WebSite site:webSites){
			try {
				System.out.println("@:"+site.getTitle());
//				RssModel model = RssHandler.buildRssModel(site.getWebsitelink());
				//获取rss头信息
				RssHead head = RssHandler.buildRssHead(site.getWebsitelink());
				//获取rss文章信息
				List<RssEntity> rssEntities = RssHandler.buildRssEntitys(site.getWebsitelink());
				for(RssEntity entity:rssEntities){
					System.out.println("当前文章@:"+Article.buildArticle(head, entity).getEtitle());
					if(this.articleController.isNewArticle(head, entity)){
						this.articleController.saveArticle(head, entity);
						newArticle.add(Article.buildArticle(head, entity));
						System.out.println("@:"+Article.buildArticle(head, entity).getEtitle()+"已保存");
					}else{
						System.out.println("@:"+Article.buildArticle(head, entity).getEtitle()+"已存在");
					}
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return newArticle;
	}
}
