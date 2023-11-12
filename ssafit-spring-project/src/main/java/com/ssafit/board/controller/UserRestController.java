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

import com.ssafit.board.model.dto.SearchCondition;
import com.ssafit.board.model.dto.User;
import com.ssafit.board.model.service.UserService;

@RestController
@RequestMapping("/apiUser")
public class UserRestController {
	// 응답을 편하게 하기 위해 상수로 지정
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private UserService userService;

	// 1. 목록
	@GetMapping("/user")
	public ResponseEntity<?> list(SearchCondition condition) {
		List<User> list = userService.search(condition);
		
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}

	// 2. 상세보기
	@GetMapping("/user/{userNum}")
	public ResponseEntity<User> detail(@PathVariable int userNum) {
		User user = userService.getUser(userNum);
		if (user != null)
			return new ResponseEntity<User>(user, HttpStatus.OK);
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}

	// 3. 등록
	@PostMapping("/user")
	public ResponseEntity<User> write(@RequestBody User user) {
		userService.regist(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

	// 4. 삭제
	@DeleteMapping("/user/{userNum}")
	public ResponseEntity<String> delete(@PathVariable int userNum) {
		if (userService.removeUser(userNum))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.NOT_FOUND);
	}

	// 5. 수정
	@PutMapping("/user")
	public ResponseEntity<String> update(@RequestBody User user) {
		if (userService.modifyUser(user))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
	}

}
