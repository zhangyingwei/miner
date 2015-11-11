package com.zhangyingwei.miner.wxclient.dao;

import java.util.List;

import com.zhangyingwei.miner.annotation.MyBatisRespository;
import com.zhangyingwei.miner.common.entity.PageInfo;
import com.zhangyingwei.miner.wxclient.entity.WXSiteInfo;

@MyBatisRespository
public interface WXInfoDao {
	
	public List<WXSiteInfo> findByPage(PageInfo pageInfo);
	
	public void saveWXSiteInfo(WXSiteInfo wxSiteInfo);
	
	public Integer getCount();
	
	public void delWXSiteInfo(String id);
	
}
