package com.zhangyingwei.miner.wxclient.util;

import java.util.List;

import com.zhangyingwei.wxreader.entity.WXInfo;
import com.zhangyingwei.miner.wxclient.entity.WXSiteInfo;

public class WXUtil {
	
	public static WXSiteInfo findWxSiteInfo(List<WXInfo> wxInfos,String wxname){
		WXInfo wxInfo = new WXInfo();
		for(WXInfo info:wxInfos){
			if(info.getName().equals(wxname)){
				wxInfo = info;
				break;
			}
		}
		return new WXSiteInfo(wxInfo);
	}
}
