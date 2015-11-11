package com.zhangyingwei.miner.rssclient.service;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhangyingwei.miner.rssclient.dao.UserDao;
import com.zhangyingwei.miner.rssclient.entity.User;

@Service
public class UserService{
	
	@Autowired
	private UserDao userDao;

	public boolean login(User user,HttpSession session) {
		User loginUser = this.userDao.findByUsername(user.getUsername());
		if(loginUser==null||loginUser.equals(null)){
			return false;
		}
		if(loginUser.getPasswd().equals(user.getPasswd())){
			session.setAttribute("logonuser", loginUser);
			return true;
		}
		return false;
	}
	
}
