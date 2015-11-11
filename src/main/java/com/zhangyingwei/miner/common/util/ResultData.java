package com.zhangyingwei.miner.common.util;

import java.util.HashMap;

public class ResultData extends HashMap{
	
	public static final String SUCCESS = "success";
	public static final String MESSAGE = "message";
	@Override
	public ResultData put(Object key, Object value) {
		super.put(key, value);
		return this;
	}
}
