package com.ssafit.board.model.dto;

public class Daily {
	private int DailyNum;
	private String exerciseDate;
	private int userNum;
	
	public Daily() {
		super();
	}

	public Daily(String exerciseDate, int userNum) {
		super();
		this.exerciseDate = exerciseDate;
		this.userNum = userNum;
	}

	public int getDailyNum() {
		return DailyNum;
	}

	public void setDailyNum(int dailyNum) {
		DailyNum = dailyNum;
	}

	public String getExerciseDate() {
		return exerciseDate;
	}

	public void setExerciseDate(String exerciseDate) {
		this.exerciseDate = exerciseDate;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	@Override
	public String toString() {
		return "Daily [DailyNum=" + DailyNum + ", exerciseDate=" + exerciseDate + ", userNum=" + userNum + "]";
	}

}
