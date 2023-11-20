package com.ssafit.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.board.model.dto.Calendar;
import com.ssafit.board.model.dto.Review;
import com.ssafit.board.model.service.CalendarService;

@RestController
@RequestMapping("/apiCalendar")
public class CalendarRestController {
	// 응답을 편하게 하기 위해 상수로 지정
	private static final String SUCCESS = "succes";
	private static final String FAIL = "fail";
	
	@Autowired
	private CalendarService calendarService;
	
	// 1. 목록
	@GetMapping("/calendar/{userNum}")
	public ResponseEntity<?> list(@PathVariable int userNum) {
		List<Calendar> list = calendarService.getList(userNum);
		
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Calendar>>(list, HttpStatus.OK);
	}
	
	// 2. 상세보기
	@GetMapping("/calendar/{id}")
	public ResponseEntity<Calendar> detail(@PathVariable int id) {
		Calendar calendar = calendarService.getCal(id);
		if(calendar != null)
			return new ResponseEntity<Calendar>(calendar, HttpStatus.OK);
		return new ResponseEntity<Calendar>(HttpStatus.NOT_FOUND);
	}
	
	// 3. 등록
	@PostMapping("/calendar")
	public ResponseEntity<Calendar> write(@RequestBody Calendar cal){
		calendarService.writeCal(cal);
		return new ResponseEntity<Calendar>(cal, HttpStatus.CREATED);
	}
	
	// 4. 삭제
	@DeleteMapping("/calendar/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		if (calendarService.removeCal(id))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.NOT_FOUND);
	}
	
	// 5. 출석 조회
	
	// 6. 출석 등록
	
	// 7. 출석 삭제
	
	
}
