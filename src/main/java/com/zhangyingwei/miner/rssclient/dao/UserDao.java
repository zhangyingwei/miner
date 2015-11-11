package com.zhangyingwei.miner.rssclient.dao;

import com.zhangyingwei.miner.annotation.MyBatisRespository;
import com.zhangyingwei.miner.rssclient.entity.User;

@MyBatisRespository
public interface UserDao {
	public User findByUsername(String username);
}
