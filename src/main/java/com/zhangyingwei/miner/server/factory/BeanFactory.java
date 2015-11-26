package com.zhangyingwei.miner.server.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhangyingwei.miner.rssclient.dao.WebSiteDao;
import com.zhangyingwei.miner.rssclient.entity.WebSite;
import com.zhangyingwei.miner.common.dao.ArticleDao;
import com.zhangyingwei.miner.server.action.SArticleHandler;
import com.zhangyingwei.miner.server.controller.SArticleController;
import com.zhangyingwei.miner.server.controller.SServerController;
import com.zhangyingwei.miner.server.controller.SWebSiteController;
import com.zhangyingwei.miner.server.service.RssServer;
import com.zhangyingwei.miner.server.service.ServerStarter;

public class BeanFactory{
	
	static ApplicationContext context = null;
	
	private static ApplicationContext getApplication(){
		if(context==null){
			context = new ClassPathXmlApplicationContext("applicationContext.xml");
		}
		return context;
	}
	
	public static ArticleDao getArticleDaoBean(){
		return  (ArticleDao) getBean(ArticleDao.class);
	}
	
	public static WebSiteDao getWebSiteDaoBean(){
		return  (WebSiteDao) getBean(WebSite.class);
	}
	
	public static SArticleController getSArticleController(){
		return (SArticleController) getBean(SArticleController.class);
	}
	public static SWebSiteController getSWebSiteController(){
		return (SWebSiteController) getBean(SWebSiteController.class);
	}
	public static SArticleHandler getArticleHandler(){
		return (SArticleHandler) getBean(SArticleHandler.class);
	}
	public static RssServer getRssServer(){
		return (RssServer) getBean(RssServer.class);
	}
	public static ServerStarter getServerStarter(){
		return (ServerStarter) getBean(ServerStarter.class);
	}
	public static SServerController getSServerController(){
		return (SServerController) getBean(SServerController.class);
	}
	
	
	public static Object getBean(String name){
		return getApplication().getBean(name);
	}
	
	public static <T> Object getBean(Class<T> c){
		return getApplication().getBean(c);
	}
}
