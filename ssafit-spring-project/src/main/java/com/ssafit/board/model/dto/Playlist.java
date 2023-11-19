package com.ssafit.board.model.dto;

public class Playlist {
	private int num;
	private String playlistTitle;
	private String playlistUrl;
	private String weather;
	
	public Playlist() {
	}

	public Playlist(String playlistTitle, String playlistUrl, String weather) {
		super();
		this.playlistTitle = playlistTitle;
		this.playlistUrl = playlistUrl;
		this.weather = weather;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getPlaylistTitle() {
		return playlistTitle;
	}

	public void setPlaylistTitle(String playlistTitle) {
		this.playlistTitle = playlistTitle;
	}

	public String getPlaylistUrl() {
		return playlistUrl;
	}

	public void setPlaylistUrl(String playlistUrl) {
		this.playlistUrl = playlistUrl;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	@Override
	public String toString() {
		return "Playlist [num=" + num + ", playlistTitle=" + playlistTitle + ", playlistUrl=" + playlistUrl
				+ ", weather=" + weather + "]";
	}
	
	
}
