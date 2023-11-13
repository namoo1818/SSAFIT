package com.ssafit.board.model.dto;

public class Follow {

	private int num;
	private int follower; //팔로우를 하는 사람
	private int followee; //팔로우를 받는 사람 
	
	public Follow() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Follow(int follower, int followee) {
		this.follower = follower;
		this.followee = followee;
	}



	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getFollower() {
		return follower;
	}

	public void setFollower(int follower) {
		this.follower = follower;
	}

	public int getFollowee() {
		return followee;
	}

	public void setFollowee(int followee) {
		this.followee = followee;
	}



	@Override
	public String toString() {
		return "Follow [num=" + num + ", follower=" + follower + ", followee=" + followee + "]";
	}
	
	
	
}
