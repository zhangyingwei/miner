package com.zhangyingwei.miner.wxclient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangyingwei.miner.common.entity.PageInfo;
import com.zhangyingwei.miner.common.util.ServiceReturn;
import com.zhangyingwei.miner.wxclient.common.WXInfoPool;
import com.zhangyingwei.miner.wxclient.dao.WXInfoDao;
import com.zhangyingwei.miner.wxclient.entity.WXSiteInfo;
import com.zhangyingwei.miner.wxclient.util.WXUtil;


@Service
public class WXSiteService {
	
	@Autowired
	private WXInfoDao wxInfoDao;
	
	public ServiceReturn findByPage(PageInfo pageInfo){
		List<WXSiteInfo> wxSiteInfos = this.wxInfoDao.findByPage(pageInfo);
		pageInfo.setTotal(this.wxInfoDao.getCount());
		ServiceReturn serviceReturn = new ServiceReturn();
		serviceReturn.setPageInfo(pageInfo).setResultList(wxSiteInfos);
		return serviceReturn;
	}
	
	public ServiceReturn saveWxInfo(String wxname){
		WXSiteInfo wxSiteInfo = WXUtil.findWxSiteInfo(WXInfoPool.getInstance().wxInfos, wxname);
		this.wxInfoDao.saveWXSiteInfo(wxSiteInfo);
		ServiceReturn serviceReturn = new ServiceReturn();
		return serviceReturn;
	}
	
	public ServiceReturn deleteWxSiteInfo(String id){
		this.wxInfoDao.delWXSiteInfo(id);
		ServiceReturn serviceReturn = new ServiceReturn();
		return serviceReturn;
	}
}
