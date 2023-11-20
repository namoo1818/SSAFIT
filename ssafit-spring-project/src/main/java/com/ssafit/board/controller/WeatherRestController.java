package com.ssafit.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.board.model.dto.Playlist;
import com.ssafit.board.model.dto.Quote;
import com.ssafit.board.model.dto.Weather;
import com.ssafit.board.model.service.WeatherService;

@RestController
@RequestMapping("/weather")
public class WeatherRestController {
	@Autowired
	private WeatherService weatherService;

	// 1. 날씨 보기
	@GetMapping("/{id}")
	public ResponseEntity<Weather> weather(@PathVariable String id) {
		Weather weather = weatherService.getWeather(id);
		if (weather != null)
			return new ResponseEntity<Weather>(weather, HttpStatus.OK);
		return new ResponseEntity<Weather>(HttpStatus.NOT_FOUND);
	}
	
	// 2. 랜덤 음악
	@GetMapping("/playlist/{id}")
	public ResponseEntity<Playlist> playlist(@PathVariable String id) {
		Playlist playlist = weatherService.getPlayList(id);
		if (playlist != null)
			return new ResponseEntity<Playlist>(playlist, HttpStatus.OK);
		return new ResponseEntity<Playlist>(HttpStatus.NOT_FOUND);
	}
	
	// 3. 랜덤 응원멘트
	@GetMapping("/quote/{id}")
	public ResponseEntity<Quote> quote(@PathVariable String id) {
		Quote quote = weatherService.getQuote(id);
		if (quote != null)
			return new ResponseEntity<Quote>(quote, HttpStatus.OK);
		return new ResponseEntity<Quote>(HttpStatus.NOT_FOUND);
	}
}
