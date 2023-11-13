package com.ssafit.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.board.model.dto.Wish;
import com.ssafit.board.model.service.WishService;

@RestController
@RequestMapping("/apiWish")
public class WishRestController {
	
	// 응답을 편하게 하기 위해 상수로 지정
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private WishService wishService;
	
	@PostMapping("/wish")
	public ResponseEntity<Wish> wish(@RequestBody Wish wish) {
		wishService.wish(wish);
		return new ResponseEntity<Wish>(wish, HttpStatus.CREATED);
	}

	@DeleteMapping("/wish")
	public ResponseEntity<String> unwish(int num) { 
		if (wishService.unwish(num))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/wish")
	public ResponseEntity<?> list(int writer) { 
		List<Wish> list = wishService.wishSearch(writer);
		
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Wish>>(list, HttpStatus.OK);
	}
	
}

