package com.ssafit.board.model.dto;

public class Video {
	
	private int num;
	private String title;
	private String keyword;
	private String channel;
	private String url;
	private int viewcnt;
	private int intensity;

	public Video() {
		super();
	}

	public Video(String title, String keyword, String channel, String url, int viewcnt, int intensity) {
		super();
		this.title = title;
		this.keyword = keyword;
		this.channel = channel;
		this.url = url;
		this.viewcnt = viewcnt;
		this.intensity = intensity;
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

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
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

	public int getIntensity() {
		return intensity;
	}

	public void setIntensity(int intensity) {
		this.intensity = intensity;
	}

	@Override
	public String toString() {
		return "Video [num=" + num + ", title=" + title + ", keyword=" + keyword + ", channel=" + channel + ", url="
				+ url + ", viewcnt=" + viewcnt + ", intensity=" + intensity + "]";
	}
	
}
