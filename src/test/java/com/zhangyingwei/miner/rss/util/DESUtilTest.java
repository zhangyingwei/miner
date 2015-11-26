package com.zhangyingwei.miner.rss.util;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import com.zhangyingwei.simpleutils.util.UtilFactory;

public class DESUtilTest {
	public static void main(String[] args) throws Exception {
		String source = "amigoxie";
        System.out.println("原文: " + source);
        String key = "zhangyingwei.com";
        String encryptData = UtilFactory.getEncodeUtil().encodeDES(source, key);
        System.out.println("加密后: " + encryptData);
        String decryptData = UtilFactory.getEncodeUtil().decodeDES(encryptData, key);
        System.out.println("解密后: " + decryptData);
	}
}
