package com.zhangyingwei.miner.rssclient.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhangyingwei.miner.common.util.ServiceReturn;
import com.zhangyingwei.miner.rssclient.dao.WebSiteDao;
import com.zhangyingwei.miner.common.entity.PageInfo;
import com.zhangyingwei.miner.rssclient.entity.WebSite;

@Service
public class WebSiteService {
	
	@Autowired
	private WebSiteDao webSiteDao;
	
	public ServiceReturn queryAll(PageInfo pageInfo){
		pageInfo.setTotal(this.webSiteDao.getCount());
		ServiceReturn serviceReturn = new ServiceReturn();
		serviceReturn.setPageInfo(pageInfo).setResultList(this.webSiteDao.queryWebSites(pageInfo));
		return serviceReturn;
	}
	
	public boolean isHas(String website){
		if(this.webSiteDao.findByWenSite(website)==null){
			return false;
		}
		return true;
	}
	
	public void add(WebSite webSite){
		this.webSiteDao.addWebSite(webSite);
	}
	
	public void delete(String website){
		this.webSiteDao.deleteSite(website);
	}
}
