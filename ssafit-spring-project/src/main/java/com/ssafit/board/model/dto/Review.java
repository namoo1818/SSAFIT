package com.ssafit.board.model.dto;

public class Review {
	
	private int num;
	private int writer;
	private String title;
	private String content;
	private int viewcnt;
	private String regdate;
	private int videoNum;
	private String userNickname;
	private String videoUrl;
	
	public Review() {
		// TODO Auto-generated constructor stub
	}

	public Review(int num, int writer, String title, String content, int viewcnt, String regdate, int videoNum,
			String userNickname, String videoUrl) {
		super();
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.viewcnt = viewcnt;
		this.regdate = regdate;
		this.videoNum = videoNum;
		this.userNickname = userNickname;
		this.videoUrl = videoUrl;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getWriter() {
		return writer;
	}

	public void setWriter(int writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getVideoNum() {
		return videoNum;
	}

	public void setVideoNum(int videoNum) {
		this.videoNum = videoNum;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	@Override
	public String toString() {
		return "Review [num=" + num + ", writer=" + writer + ", title=" + title + ", content=" + content + ", viewcnt="
				+ viewcnt + ", regdate=" + regdate + ", videoNum=" + videoNum + ", userNickname=" + userNickname
				+ ", videoUrl=" + videoUrl + "]";
	}
	
	

	
	

}
