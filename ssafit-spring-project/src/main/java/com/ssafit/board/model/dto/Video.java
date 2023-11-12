package com.ssafit.board.model.dto;

public class Video {
	
	private int num;
	private String title;
	private String part;
	private String channel;
	private String url;
	private int viewcnt;

	public Video() {
		super();
	}
	
	public Video(String title, String part, String channel, String url) {
		super();
		this.title = title;
		this.part = part;
		this.channel = channel;
		this.url = url;
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	@Override
	public String toString() {
		return "Video [num=" + num + ", title=" + title + ", part=" + part + ", channel=" + channel + ", url=" + url
				+ ", viewcnt=" + viewcnt + "]";
	}
	
	
	
}
