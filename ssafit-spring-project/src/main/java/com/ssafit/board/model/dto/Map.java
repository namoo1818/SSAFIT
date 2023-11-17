package com.ssafit.board.model.dto;

public class Map {
	private int mapId;
	private float mapLatitud;
	private float mapLongitud;
	private String mapTitle;
	private String mapContent;
	private int userNum;
	
	public Map() {
		super();
	}

	public Map(float mapLatitud, float mapLongitud, String mapTitle, String mapContent, int userNum) {
		super();
		this.mapLatitud = mapLatitud;
		this.mapLongitud = mapLongitud;
		this.mapTitle = mapTitle;
		this.mapContent = mapContent;
		this.userNum = userNum;
	}

	public int getMapId() {
		return mapId;
	}

	public void setMapId(int mapId) {
		this.mapId = mapId;
	}

	public float getMapLatitud() {
		return mapLatitud;
	}

	public void setMapLatitud(float mapLatitud) {
		this.mapLatitud = mapLatitud;
	}

	public float getMapLongitud() {
		return mapLongitud;
	}

	public void setMapLongitud(float mapLongitud) {
		this.mapLongitud = mapLongitud;
	}

	public String getMapTitle() {
		return mapTitle;
	}

	public void setMapTitle(String mapTitle) {
		this.mapTitle = mapTitle;
	}

	public String getMapContent() {
		return mapContent;
	}

	public void setMapContent(String mapContent) {
		this.mapContent = mapContent;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	@Override
	public String toString() {
		return "Map [mapId=" + mapId + ", mapLatitud=" + mapLatitud + ", mapLongitud=" + mapLongitud + ", mapTitle="
				+ mapTitle + ", mapContent=" + mapContent + ", userNum=" + userNum + "]";
	}
	
	
}
