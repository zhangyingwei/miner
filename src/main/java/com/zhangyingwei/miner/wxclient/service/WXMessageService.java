package com.zhangyingwei.miner.wxclient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangyingwei.miner.common.entity.PageInfo;
import com.zhangyingwei.miner.common.util.ServiceReturn;
import com.zhangyingwei.miner.wxclient.dao.WXMessageDao;
import com.zhangyingwei.miner.wxclient.entity.WXMessageInfo;

@Service
public class WXMessageService {
	
	@Autowired
	private WXMessageDao wxMessageDao;
	
	public ServiceReturn queryByPage(PageInfo pageInfo){
		List<WXMessageInfo> wxMessageInfos = this.wxMessageDao.queryByPageInfo(pageInfo);
		ServiceReturn sReturn = new ServiceReturn();
		pageInfo.setTotal(this.wxMessageDao.getCount());
		sReturn.setResultList(wxMessageInfos).setPageInfo(pageInfo);
		return sReturn;
	}
	
	
}
