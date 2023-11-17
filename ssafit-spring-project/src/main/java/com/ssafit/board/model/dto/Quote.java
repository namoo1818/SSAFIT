package com.ssafit.board.model.dto;

public class Quote {
	private int num;
	private String writer;
	private String content;
	private int weather;
	
	public Quote() {
	}
	
	public Quote(String writer, String content, int weather) {
		super();
		this.writer = writer;
		this.content = content;
		this.weather = weather;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getWeather() {
		return weather;
	}

	public void setWeater(int weather) {
		this.weather = weather;
	}

	@Override
	public String toString() {
		return "Quote [num=" + num + ", writer=" + writer + ", content=" + content + ", weather=" + weather + "]";
	}
	
}
