package com.ssafit.board.model.service;

import com.ssafit.board.model.dto.Playlist;
import com.ssafit.board.model.dto.Quote;
import com.ssafit.board.model.dto.Weather;

public interface WeatherService {
	// 날씨 코드로 검색
	Weather getWeather(String id);
	
	// 음악 추천
	Playlist getPlayList(String id);
		
	// 응원멘트 추천
	Quote getQuote(String id);
}
