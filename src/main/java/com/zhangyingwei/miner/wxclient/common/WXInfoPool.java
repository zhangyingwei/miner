package com.zhangyingwei.miner.wxclient.common;

import java.util.ArrayList;
import java.util.List;

import com.zhangyingwei.wxreader.entity.WXInfo;

public class WXInfoPool {
	
	public WXInfoPool(){
		
	}
	
	public static List<WXInfo> wxInfos = null;
	
	public static void setWXInfos(List<WXInfo> wInfos){
		wxInfos = wInfos;
	}
	
	private static class WXInfoPoolHandler{
		private static WXInfoPool wxInfoPool = new WXInfoPool();
	}
	
	public static WXInfoPool getInstance(){
		return WXInfoPoolHandler.wxInfoPool;
	}
}
