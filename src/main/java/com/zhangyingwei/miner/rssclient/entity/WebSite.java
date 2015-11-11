package com.zhangyingwei.miner.rssclient.entity;

import java.io.Serializable;
import java.util.Date;


public class WebSite  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String websitelink;
	private String title;
	private String link;
	private String updated;
	private String description;
	public WebSite(){
		
	}
	public WebSite(String website, String title, String link,
			String updated, String description) {
		super();
		this.websitelink = website;
		this.title = title;
		this.link = link;
		this.updated = updated;
		this.description = description;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getWebsitelink() {
		return websitelink;
	}
	public WebSite setWebsitelink(String websitelink) {
		this.websitelink = websitelink;
		return this;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		if(this.link==null||this.link.length()==0){
			this.link = this.getWebsitelink().substring(0,this.getWebsitelink().lastIndexOf("/"));
		}
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getUpdated() {
		updated = (updated==null||updated.length()==0)?new Date().toString():updated;
		return updated;
	}
	public void setUpdated(String updated) {
		this.updated = updated;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "WebSite [id=" + id + ", websitelink=" + websitelink
				+ ", title=" + title + ", link=" + link + ", updated="
				+ updated + ", description=" + description + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((updated == null) ? 0 : updated.hashCode());
		result = prime * result
				+ ((websitelink == null) ? 0 : websitelink.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WebSite other = (WebSite) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (updated == null) {
			if (other.updated != null)
				return false;
		} else if (!updated.equals(other.updated))
			return false;
		if (websitelink == null) {
			if (other.websitelink != null)
				return false;
		} else if (!websitelink.equals(other.websitelink))
			return false;
		return true;
	}
}
