package com.zhangyingwei.miner.common.entity;

public class PageInfo {
	private Integer begin;
	private Integer end;
	private Integer pageSize = 8;
	private Integer currentPage = 1;
	private Integer total = 0;
	public Integer getCurrentPage() {
		return currentPage;
	}
	public PageInfo setCurrentPage(Integer currentPage) {
		if(currentPage!=null){
			this.currentPage = currentPage;
		}
		return this;
	}
	public Integer getBegin() {
		return (this.getCurrentPage()-1)*pageSize;
	}
	public PageInfo setBegin(Integer begin) {
		this.begin = begin;
		return this;
	}
	public Integer getEnd() {
		return end;
	}
	public PageInfo setEnd(Integer end) {
		this.end = end;
		return this;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public PageInfo setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
		return this;
	}
	public Integer getTotalPage() {
		Integer size = total/pageSize;
		if((total%pageSize)==0){
			if(size==0){
				size=1;
			}
			return size;
		}
		return size+1;
	}
	public Integer getTotal() {
		return total;
	}
	public PageInfo setTotal(Integer total) {
		if(total==null){
			this.total = 0;
		}else{
			this.total = total;
		}
		return this;
	}
	@Override
	public String toString() {
		return "PageInfo [begin=" + begin + ", end=" + end + ", pageSize="
				+ pageSize + ", currentPage=" + currentPage + ", total="
				+ total + "]";
	}
	public static PageInfo getPageInfo(String currentPage){
		if(currentPage==null){
			currentPage="1";
		}
		return new PageInfo().setCurrentPage(Integer.parseInt(currentPage));
	}
}
