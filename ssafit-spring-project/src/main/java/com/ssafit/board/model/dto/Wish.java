package com.ssafit.board.model.dto;

public class Wish {

	private int num; //인덱스 
	private int videonum; //비디오 번호 
	private int userNum; //해당 위시 작성자(소유자) 
	private String userNickname;
	private String videoTitle;
	private String videoUrl;
	
	public Wish() {
		// TODO Auto-generated constructor stub
	}

	public Wish(int num, int videonum, int userNum, String userNickname, 
			String videoTitle, String videoUrl) {
		super();
		this.videonum = videonum;
		this.userNum = userNum;
		this.userNickname = userNickname;
		this.videoTitle = videoTitle;
		this.videoUrl = videoUrl;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getVideonum() {
		return videonum;
	}

	public void setVideonum(int videonum) {
		this.videonum = videonum;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	
	

	public String getVideoTitle() {
		return videoTitle;
	}

	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	@Override
	public String toString() {
		return "Wish [num=" + num + ", videonum=" + videonum + ", userNum=" + userNum + ", userNickname=" + userNickname
				+ ", videoTitle=" + videoTitle + ", videoUrl=" + videoUrl + "]";
	}



	
	
	
}
