package com.zhangyingwei.miner.rssclient.dao;

import java.util.List;

import com.zhangyingwei.miner.annotation.MyBatisRespository;
import com.zhangyingwei.miner.common.entity.PageInfo;
import com.zhangyingwei.miner.rssclient.entity.WebSite;

@MyBatisRespository
public interface WebSiteDao {
	public List<WebSite> queryWebSites(PageInfo pageInfo);
	
	public List<WebSite> queryAllWebSites();
	
	public Integer getCount();
	
	public WebSite findByWenSite(String website);
	
	public void addWebSite(WebSite webSite);
	
	public void deleteSite(String website);
}
