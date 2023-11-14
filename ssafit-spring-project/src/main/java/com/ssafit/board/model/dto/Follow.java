package com.ssafit.board.model.dto;

public class Follow {

	private int num;
	private int followernum; 
	private int followeenum; 
	private String follower; //팔로우를 하는 사람
	private String followee; //팔로우를 받는 사람 
	
	public Follow() {
		// TODO Auto-generated constructor stub
	}

	public Follow(int followernum, int followeenum, String follower, String followee) {
		super();
		this.followernum = followernum;
		this.followeenum = followeenum;
		this.follower = follower;
		this.followee = followee;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getFollowernum() {
		return followernum;
	}

	public void setFollowernum(int followernum) {
		this.followernum = followernum;
	}

	public int getFolloweenum() {
		return followeenum;
	}

	public void setFolloweenum(int followeenum) {
		this.followeenum = followeenum;
	}

	public String getFollower() {
		return follower;
	}

	public void setFollower(String follower) {
		this.follower = follower;
	}

	public String getFollowee() {
		return followee;
	}

	public void setFollowee(String followee) {
		this.followee = followee;
	}

	@Override
	public String toString() {
		return "Follow [num=" + num + ", followernum=" + followernum + ", followeenum=" + followeenum + ", follower="
				+ follower + ", followee=" + followee + "]";
	}
	
	

	
	
}
