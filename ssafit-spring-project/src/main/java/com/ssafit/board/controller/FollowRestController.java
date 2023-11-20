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

import com.ssafit.board.model.dto.Follow;
import com.ssafit.board.model.service.FollowService;

@RestController
@RequestMapping("/follow")
public class FollowRestController {

	// 응답을 편하게 하기 위해 상수로 지정
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private FollowService followService;

	@PostMapping("")
	public ResponseEntity<Follow> follow(@RequestBody Follow follow) {
		followService.follow(follow);
		return new ResponseEntity<Follow>(follow, HttpStatus.CREATED);
	}

	@DeleteMapping("")
	public ResponseEntity<String> unfollow(int num) { 
		if (followService.unfollow(num))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/follower")
	public ResponseEntity<?> followerList(int myNum) { 
		List<Follow> list = followService.followerSearch(myNum); 
		
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Follow>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/following")
	public ResponseEntity<?> followingList(int myNum) { 
		List<Follow> list = followService.followingSearch(myNum);
		
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Follow>>(list, HttpStatus.OK);
	}
	
}

