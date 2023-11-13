package com.ssafit.board.model.dto;

public class Wish {

	private int num; //인덱스 
	private int videonum; //비디오 번호 
	private int writer; //해당 위시 작성자(소유자) 
	
	public Wish() {
		// TODO Auto-generated constructor stub
	}

	public Wish(int num, int videonum, int writer) {
		this.videonum = videonum;
		this.writer = writer;
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

	public int getWriter() {
		return writer;
	}

	public void setWriter(int writer) {
		this.writer = writer;
	}

	@Override
	public String toString() {
		return "Wish [num=" + num + ", videonum=" + videonum + ", writer=" + writer + "]";
	}
	
	
	
}
