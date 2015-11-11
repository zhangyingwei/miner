package com.zhangyingwei.miner.common.util;

import java.util.List;
import java.util.Properties;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import org.springframework.stereotype.Component;
import com.zhangyingwei.miner.common.entity.Article;
import com.zhangyingwei.handler.MailHandler;
import com.zhangyingwei.model.MailMessage;

@Component
public class MailUtil {
	
	private static Properties mailProperties = PropertielUtil.loadMailProperties();
	
	//发送邮件
	public static void mailSend(String title,String content){
		String fromaddress = mailProperties.getProperty("fromaddress");
		String frompasswd = mailProperties.getProperty("frompasswd");
		String toaddress = mailProperties.getProperty("toaddress");
		MailHandler maillogin = MailHandler.getInstence(fromaddress,frompasswd);
		try {
			maillogin.sendMessage(
					new MailMessage(maillogin.getMail())
					.setToAddress(toaddress)
					.setSubject(title)
					.addText(content)
					.init());
		} catch (NoSuchProviderException e) {
			System.out.println(e);
		} catch (MessagingException e) {
			System.out.println(e);
		}
	}
	
	public static void sendNoticeMail(List<Article> articles){
		String mailTitle = "未读文章通知";
		String mailBody = buildMailBody(articles);
		mailSend(mailTitle, mailBody);
	}
	
	private static String buildMailBody(List<Article> articles){
		if(articles.size()==0){
			return "今天没有未读文章哦，赶紧寻找有价值的博客添加订阅吧";
		}
		Integer sum = articles.size();
		StringBuffer sbuffer = new StringBuffer();
		sbuffer.append("<h2>");
		sbuffer.append("您好，一共有");
		sbuffer.append(sum.toString());
		sbuffer.append("篇未读文章等待您阅读！");
		sbuffer.append("</h2>");
		sbuffer.append("<ul>");
		for(Article a:articles){
			sbuffer.append("<li>");
			sbuffer.append("<a href=\"");
			sbuffer.append(a.getElink());
			sbuffer.append("\" target=\"_blank\">");
			sbuffer.append(a.getEtitle());
			sbuffer.append("</a>");
			sbuffer.append("</li>");
		}
		sbuffer.append("</ul>");
		return sbuffer.toString();
	}
}
