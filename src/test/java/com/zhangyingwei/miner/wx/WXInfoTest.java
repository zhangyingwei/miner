package com.zhangyingwei.miner.wx;

import java.util.List;

import com.zhangyingwei.wxreader.entity.WXInfo;
import com.zhangyingwei.wxreader.handler.WXHandler;

public class WXInfoTest {
	public static void main(String[] args) {
		List<WXInfo> wxinfos = WXHandler.getWxInfo("开源");
		System.out.println(wxinfos);
	}
}
