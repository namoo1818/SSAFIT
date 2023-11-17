package com.ssafit.board.model.dto;

public class Calendar {
	private int num;
	private String title;
	private String content;
	private String start;
	private String end;
	private int userNum;
	
	public Calendar() {
	}

	public Calendar(String title, String content, String start, String end, int userNum) {
		super();
		this.title = title;
		this.content = content;
		this.start = start;
		this.end = end;
		this.userNum = userNum;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	@Override
	public String toString() {
		return "Calendar [num=" + num + ", title=" + title + ", content=" + content + ", start=" + start + ", end="
				+ end + ", userNum=" + userNum + "]";
	}
	
}
