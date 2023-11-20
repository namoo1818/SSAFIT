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
import com.ssafit.board.model.dto.Daily;
import com.ssafit.board.model.dto.Review;
import com.ssafit.board.model.service.CalendarService;

@RestController
@RequestMapping("/calendar")
public class CalendarRestController {
	// 응답을 편하게 하기 위해 상수로 지정
	private static final String SUCCESS = "succes";
	private static final String FAIL = "fail";
	
	@Autowired
	private CalendarService calendarService;
	
	// 1. 목록
	@GetMapping("/{userNum}")
	public ResponseEntity<?> list(@PathVariable int userNum) {
		List<Calendar> list = calendarService.getList(userNum);
		
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Calendar>>(list, HttpStatus.OK);
	}
	
	// 2. 상세보기
	@GetMapping("/detail/{id}")
	public ResponseEntity<Calendar> detail(@PathVariable int id) {
		Calendar calendar = calendarService.getCal(id);
		if(calendar != null)
			return new ResponseEntity<Calendar>(calendar, HttpStatus.OK);
		return new ResponseEntity<Calendar>(HttpStatus.NOT_FOUND);
	}
	
	// 3. 등록
	@PostMapping("")
	public ResponseEntity<Calendar> write(@RequestBody Calendar cal){
		calendarService.writeCal(cal);
		return new ResponseEntity<Calendar>(cal, HttpStatus.CREATED);
	}
	
	// 4. 삭제
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		if (calendarService.removeCal(id))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.NOT_FOUND);
	}
	
	// 5. 수정
	@PutMapping("")
	public ResponseEntity<String> update(@RequestBody Calendar cal) {
		if (calendarService.modifyCal(cal))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
	}
	
	// 6. 출석 전체 조회
	@GetMapping("/daily/{userNum}")
	public ResponseEntity<?> dailyList(@PathVariable int userNum) {
		List<Daily> list = calendarService.gettDaily(userNum);
		
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Daily>>(list, HttpStatus.OK);
	}
	
	// 7. 상세보기
	@GetMapping("/daily/detail/{id}")
	public ResponseEntity<Daily> dailyDetail(@PathVariable int id) {
		Daily daily = calendarService.getDailyOne(id);
		if(daily != null)
			return new ResponseEntity<Daily>(daily, HttpStatus.OK);
		return new ResponseEntity<Daily>(HttpStatus.NOT_FOUND);
	}
	
	// 8. 출석 등록
	@PostMapping("/daily")
	public ResponseEntity<Daily> writeDaily(@RequestBody Daily daily){
		calendarService.writeDaily(daily);
		return new ResponseEntity<Daily>(daily, HttpStatus.CREATED);
	}
	
	// 9. 출석 삭제
	@DeleteMapping("/daily/{id}")
	public ResponseEntity<String> deleteDaily(@PathVariable int id) {
		if (calendarService.removeDaily(id))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.NOT_FOUND);
	}
	
}
