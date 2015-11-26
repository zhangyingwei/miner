package com.zhangyingwei.miner.server.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.springframework.stereotype.Component;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;
import com.zhangyingwei.miner.common.util.PropertielUtil;
import com.zhangyingwei.miner.server.factory.BeanFactory;

@Component
public class ServerStarter{
	
	private Thread thread = null;
	
	public void serverRun(){
		thread = new Thread(new Runnable() {
			public void run() {
				Properties properties = PropertielUtil.loadProperties("sever.properties");
				Integer autorun = Integer.parseInt(properties.getProperty("server.autorun"));
				String timerun = properties.getProperty("server.runtime");
				List timeruns = new ArrayList();
				if(timerun==null||timerun.trim().length()==0){
					timeruns.add(7);
				}else{
					String[] ts = timerun.split(",");
					timeruns = Arrays.asList(ts);
				}
				System.out.println("@autorun:"+autorun);
				System.out.println("@timerun"+timerun);
				while(true){
					try {
						if(RssServer.SERVER_AUTORUN.equals(autorun)){
							String time = new Date().getHours()+"";
							System.out.println(time);
							if(timeruns.indexOf(time)>=0){
								BeanFactory.getRssServer().doRss();
								System.out.println("@执行完doRss"+new Date());
							}
							Thread.sleep(1000*60*60);
						}
					} catch (Exception e) {
						System.out.println(e);
					}
				}
			}
		});
		thread.setName("rssreader4j-server");
		thread.start();
	}
	
	public void serverStop(){
		if(this.thread!=null){
			this.thread.stop();
		}
	}
}
