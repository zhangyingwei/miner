package com.zhangyingwei.miner.common.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.zhangyingwei.miner.server.controller.SServerController;
import com.zhangyingwei.miner.server.factory.BeanFactory;

@Component
public class ApplicationContextListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		SServerController server = BeanFactory.getSServerController();
		server.ServerStop();
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		SServerController server = BeanFactory.getSServerController();
		server.ServerStart();
	}

}
