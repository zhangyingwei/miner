package com.zhangyingwei.miner.wxclient.entity;

public class WXMessageInfo {
	private Integer id;
	private String stitle;
	private String key;
	private String title;
	private String decription;
	private String publishTime;
	private String docid;
	private String url;
	private String location;
	private String delflag = "0";
	
	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

	public String getStitle() {
		return stitle;
	}

	public void setStitle(String stitle) {
		this.stitle = stitle;
	}

	
	@Override
	public String toString() {
		return "WXMessageInfo [id=" + id + ", stitle=" + stitle + ", key="
				+ key + ", title=" + title + ", decription=" + decription
				+ ", publishTime=" + publishTime + ", docid=" + docid
				+ ", url=" + url + ", location=" + location + ", delflag="
				+ delflag + "]";
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDecription() {
		return decription;
	}
	public void setDecription(String decription) {
		this.decription = decription;
	}
	public String getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}
	public String getDocid() {
		return docid;
	}
	public void setDocid(String docid) {
		this.docid = docid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
