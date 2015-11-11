package com.zhangyingwei.miner.wxclient.dao;

import java.util.List;

import com.zhangyingwei.miner.annotation.MyBatisRespository;
import com.zhangyingwei.miner.common.entity.PageInfo;
import com.zhangyingwei.miner.wxclient.entity.WXMessageInfo;

@MyBatisRespository
public interface WXMessageDao {
	
	public List<WXMessageInfo> queryByPageInfo(PageInfo pageInfo);
	
	public Integer getCount();
	
	public void deleteWxMessageInfo(String id);
}
