package com.zhangyingwei.miner.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.zhangyingwei.miner.rssclient.dao.WebSiteDao;
import com.zhangyingwei.miner.rssclient.entity.WebSite;

@Controller
public class SWebSiteController {
	
	@Autowired
	private WebSiteDao webSiteDao;
	
	public List<WebSite> queryAllWebSites(){
		return this.webSiteDao.queryAllWebSites();
	}
}
