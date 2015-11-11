package com.zhangyingwei.miner.common.util;

import java.util.List;

import com.zhangyingwei.miner.common.entity.PageInfo;


public class ServiceReturn {
	public List resultList;
	public PageInfo pageInfo;
	public Object resuObject;
	public List getResultList() {
		return resultList;
	}
	public ServiceReturn setResultList(List resultList) {
		this.resultList = resultList;
		return this;
	}
	public PageInfo getPageInfo() {
		return pageInfo;
	}
	public ServiceReturn setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
		return this;
	}
	public Object getResuObject() {
		return resuObject;
	}
	public ServiceReturn setResuObject(Object resuObject) {
		this.resuObject = resuObject;
		return this;
	}
}
