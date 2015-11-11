package com.zhangyingwei.miner.common.util;

import com.zhangyingwei.miner.rssclient.entity.WebSite;
import com.zhangyingwei.handler.RssHandler;
import com.zhangyingwei.model.RssHead;

public class WebSiteUtil {
	
	public static WebSite buildWebSite(String url){
		RssHead rssHead = RssHandler.buildRssHead(url);
		WebSite webSite = new WebSite();
		webSite.setTitle(rssHead.getTitle());
		webSite.setLink(rssHead.getLink());
		webSite.setUpdated(rssHead.getUpdated());
		webSite.setDescription(rssHead.getDescription());
		return webSite;
	}
}
