package com.ssafit.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.board.model.dto.Calendar;
import com.ssafit.board.model.dto.Review;
import com.ssafit.board.model.dto.kakaoMap;
import com.ssafit.board.model.service.KakaoMapService;

@RestController
@RequestMapping("/map")
public class KakaoMapRestController {
	// 응답을 편하게 하기 위해 상수로 지정
	private static final String SUCCESS = "succes";
	private static final String FAIL = "fail";

	@Autowired
	private KakaoMapService kakaoMapService;
	
	// 1. 목록
	@GetMapping("/{id}")
	public ResponseEntity<?> list(@PathVariable int id) {
		List<kakaoMap> list = kakaoMapService.getList(id);
		
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<kakaoMap>>(list, HttpStatus.OK);
	}
	
	//2. 상세보기
	@GetMapping("/detail/{id}")
	public ResponseEntity<kakaoMap> detail(@PathVariable int id) {
		kakaoMap kakaoMap = kakaoMapService.getMap(id);
		if(kakaoMap != null)
			return new ResponseEntity<kakaoMap>(kakaoMap, HttpStatus.OK);
		return new ResponseEntity<kakaoMap>(HttpStatus.NOT_FOUND);
	}
	
	// 3. 등록
	@PostMapping("")
	public ResponseEntity<kakaoMap> write(@RequestBody kakaoMap kakaoMap){
		kakaoMapService.writeMap(kakaoMap);
		return new ResponseEntity<kakaoMap>(kakaoMap, HttpStatus.CREATED);
	}
	
	// 4. 삭제
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		if (kakaoMapService.removeMap(id))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.NOT_FOUND);
	}
	
	// 5. 수정
	@PutMapping("")
	public ResponseEntity<String> update(@RequestBody kakaoMap kakaoMap) {
		if (kakaoMapService.modifyMap(kakaoMap))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
	}
}
