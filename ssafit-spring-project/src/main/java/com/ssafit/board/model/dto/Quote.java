package com.ssafit.board.model.dto;

public class Quote {
	private int num;
	private String writer;
	private String content;
	private String weather;
	
	public Quote() {
	}
	
	public Quote(String writer, String content, String weather) {
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

	public String getWeather() {
		return weather;
	}

	public void setWeater(String weather) {
		this.weather = weather;
	}

	@Override
	public String toString() {
		return "Quote [num=" + num + ", writer=" + writer + ", content=" + content + ", weather=" + weather + "]";
	}
	
}
