package com.ssafit.board.model.dto;

public class ViewLog {
	private String viewDate;
	private int videoNum;
	private int userNum;
	
	public ViewLog() {
		super();
	}

	public ViewLog(String viewDate, int videoNum, int userNum) {
		super();
		this.viewDate = viewDate;
		this.videoNum = videoNum;
		this.userNum = userNum;
	}

	public String getViewDate() {
		return viewDate;
	}

	public void setViewDate(String viewDate) {
		this.viewDate = viewDate;
	}

	public int getVideoNum() {
		return videoNum;
	}

	public void setVideoNum(int videoNum) {
		this.videoNum = videoNum;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	@Override
	public String toString() {
		return "ViewLog [viewDate=" + viewDate + ", videoNum=" + videoNum + ", userNum=" + userNum + "]";
	}
	
	
}
