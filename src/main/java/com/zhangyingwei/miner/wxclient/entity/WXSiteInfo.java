package com.zhangyingwei.miner.wxclient.entity;

import com.zhangyingwei.entity.WXInfo;

public class WXSiteInfo {
	public Integer id;
	public String wxcode;
	public String wxname;
	public String description;
	public String url;
	public String openid;
	public String ext;
	public String page;
	public String cb;
	public String gzhArtKeyWord;
	public String updatetime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getWxcode() {
		return wxcode;
	}
	public void setWxcode(String wxcode) {
		this.wxcode = wxcode;
	}
	public String getWxname() {
		return wxname.trim();
	}
	public void setWxname(String wxname) {
		this.wxname = wxname;
	}
	public String getDescription() {
		return description.trim();
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url.trim();
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getCb() {
		return cb;
	}
	public void setCb(String cb) {
		this.cb = cb;
	}
	public String getGzhArtKeyWord() {
		return gzhArtKeyWord;
	}
	public void setGzhArtKeyWord(String gzhArtKeyWord) {
		this.gzhArtKeyWord = gzhArtKeyWord;
	}
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	@Override
	public String toString() {
		return "WXSiteInfo [id=" + id + ", wxcode=" + wxcode + ", wxname="
				+ wxname + ", description=" + description + ", url=" + url
				+ ", openid=" + openid + ", ext=" + ext + ", page=" + page
				+ ", cb=" + cb + ", gzhArtKeyWord=" + gzhArtKeyWord
				+ ", updatetime=" + updatetime + "]";
	}
	
	/**
	 * WXSiteInfo to  WXInfo
	 * @return WXInfo
	 */
	public WXInfo toWXInfo(){
		WXInfo wxInfo = new WXInfo();
		wxInfo.setDescription(this.getDescription());
		wxInfo.setCb(this.getCb());
		wxInfo.setExt(this.getExt());
		wxInfo.setGzhArtKeyWord(this.getGzhArtKeyWord());
		wxInfo.setName(this.getWxname());
		wxInfo.setOpenid(this.getOpenid());
		wxInfo.setPage(this.getPage());
		wxInfo.setUrl(url);
		return wxInfo;
	}
	
	/**
	 * wxInfo TO WXSiteInfo
	 * @param wxInfo
	 */
	public WXSiteInfo (WXInfo wxInfo){
		this.setCb(wxInfo.getCb());
		this.setDescription(wxInfo.getDescription());
		this.setExt(wxInfo.getExt());
		this.setGzhArtKeyWord(wxInfo.getGzhArtKeyWord());
		this.setOpenid(wxInfo.getOpenid());
		this.setPage(wxInfo.getPage());
		this.setUpdatetime(wxInfo.getT());
		this.setUrl(wxInfo.getUrl());
		this.setWxcode((wxInfo.getDescription()==null||wxInfo.getDescription().trim().length()==0)?"":wxInfo.getDescription().split("：")[1].trim());
		this.setWxname(wxInfo.getName());
	}
	
	public WXSiteInfo(){}
}
