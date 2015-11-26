package com.zhangyingwei.miner.wx;

import java.util.List;

import com.zhangyingwei.wxreader.entity.WXInfo;
import com.zhangyingwei.wxreader.entity.WXMessage;
import com.zhangyingwei.wxreader.handler.WXHandler;

public class WXTest {
	public static void main(String[] args) {
		List<WXInfo> wxinfos = WXHandler.getWxInfo("考研专有助手");
		System.out.println(wxinfos);
		
//		WXMessage wxMessage = WXHandler.getWxMessages(WXHandler.getWxInfo("考研专有助手").get(0)).get(0);
//		System.out.println(wxMessage);
	}
}
