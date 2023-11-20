package com.ssafit.board.model.dto;

public class DailyExercise {
	private String exerciseDate;
	private int userNum;
	
	public DailyExercise() {
		super();
	}

	public DailyExercise(String exerciseDate, int userNum) {
		super();
		this.exerciseDate = exerciseDate;
		this.userNum = userNum;
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
		return "DailyExercise [exerciseDate=" + exerciseDate + ", userNum=" + userNum + "]";
	}
	
}
