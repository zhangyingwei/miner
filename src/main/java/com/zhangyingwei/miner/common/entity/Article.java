package com.zhangyingwei.miner.common.entity;

import java.io.Serializable;

import com.zhangyingwei.model.RssEntity;
import com.zhangyingwei.model.RssHead;
import com.zhangyingwei.model.RssModel;

public class Article  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String stitle;
	private String slink;
	private String supdated;
	private String etitle;
	private String elink;
	private String epublished;
	private String edescription;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStitle() {
		return stitle;
	}
	public void setStitle(String stitle) {
		this.stitle = stitle;
	}
	public String getSlink() {
		return slink;
	}
	public void setSlink(String slink) {
		this.slink = slink;
	}
	public String getSupdated() {
		return supdated;
	}
	public void setSupdated(String supdated) {
		this.supdated = supdated;
	}
	public String getEtitle() {
		return etitle;
	}
	public void setEtitle(String etitle) {
		this.etitle = etitle;
	}
	public String getElink() {
		return elink;
	}
	public void setElink(String elink) {
		this.elink = elink;
	}
	public String getEpublished() {
		return epublished;
	}
	public void setEpublished(String epublished) {
		this.epublished = epublished;
	}
	public String getEdescription() {
		return edescription;
	}
	public void setEdescription(String edescription) {
		this.edescription = edescription;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", stitle=" + stitle + ", slink=" + slink
				+ ", supdated=" + supdated + ", etitle=" + etitle + ", elink="
				+ elink + ", epublished=" + epublished + ", edescription="
				+ edescription + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((edescription == null) ? 0 : edescription.hashCode());
		result = prime * result + ((elink == null) ? 0 : elink.hashCode());
		result = prime * result
				+ ((epublished == null) ? 0 : epublished.hashCode());
		result = prime * result + ((etitle == null) ? 0 : etitle.hashCode());
		result = prime * result + id;
		result = prime * result + ((slink == null) ? 0 : slink.hashCode());
		result = prime * result + ((stitle == null) ? 0 : stitle.hashCode());
		result = prime * result
				+ ((supdated == null) ? 0 : supdated.hashCode());
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
		Article other = (Article) obj;
		if (edescription == null) {
			if (other.edescription != null)
				return false;
		} else if (!edescription.equals(other.edescription))
			return false;
		if (elink == null) {
			if (other.elink != null)
				return false;
		} else if (!elink.equals(other.elink))
			return false;
		if (epublished == null) {
			if (other.epublished != null)
				return false;
		} else if (!epublished.equals(other.epublished))
			return false;
		if (etitle == null) {
			if (other.etitle != null)
				return false;
		} else if (!etitle.equals(other.etitle))
			return false;
		if (id != other.id)
			return false;
		if (slink == null) {
			if (other.slink != null)
				return false;
		} else if (!slink.equals(other.slink))
			return false;
		if (stitle == null) {
			if (other.stitle != null)
				return false;
		} else if (!stitle.equals(other.stitle))
			return false;
		if (supdated == null) {
			if (other.supdated != null)
				return false;
		} else if (!supdated.equals(other.supdated))
			return false;
		return true;
	}
	
	public static Article buildArticle(RssHead rssHead,RssEntity rssEntity){
		Article article = new Article();
		article.setStitle(rssHead.getTitle());
		article.setSlink(rssHead.getLink());
		article.setSupdated(rssHead.getUpdated());
		article.setEtitle(rssEntity.getTitle());
		article.setElink(rssEntity.getLink());
		article.setEpublished(rssEntity.getPublished());
		article.setEdescription(rssEntity.getDescription());
		return article;
	}
}
