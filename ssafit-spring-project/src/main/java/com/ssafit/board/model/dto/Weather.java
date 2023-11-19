package com.ssafit.board.model.dto;

public class Weather {
	private int weatherNum;
	private String weatherMain;
	private String weatherCategory;
	
	public Weather() {
		super();
	}

	public Weather(String weatherMain, String weatherCategory) {
		super();
		this.weatherMain = weatherMain;
		this.weatherCategory = weatherCategory;
	}

	public int getWeatherNum() {
		return weatherNum;
	}

	public void setWeatherNum(int weatherNum) {
		this.weatherNum = weatherNum;
	}

	public String getWeatherMain() {
		return weatherMain;
	}

	public void setWeatherMain(String weatherMain) {
		this.weatherMain = weatherMain;
	}

	public String getWeatherCategory() {
		return weatherCategory;
	}

	public void setWeatherCategory(String weatherCategory) {
		this.weatherCategory = weatherCategory;
	}

	@Override
	public String toString() {
		return "Weather [weatherNum=" + weatherNum + ", weatherMain=" + weatherMain + ", weatherCategory="
				+ weatherCategory + "]";
	}


}
