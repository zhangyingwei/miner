package com.zhangyingwei.miner.wx;

import java.util.List;

import com.zhangyingwei.entity.WXInfo;
import com.zhangyingwei.handler.WXHandler;

public class WXTest {
	public static void main(String[] args) {
		List<WXInfo> wxinfos = WXHandler.getWxInfo("��Դ�й�");
		System.out.println(wxinfos);
	}
}
