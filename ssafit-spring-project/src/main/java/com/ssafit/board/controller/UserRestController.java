package com.ssafit.board.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.ssafit.board.util.JwtUtil;

@RestController
@RequestMapping("/apiUser")
public class UserRestController {
	// 응답을 편하게 하기 위해 상수로 지정
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private UserService userService;

	@Autowired
	private JwtUtil jwtUtil;

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

	@PostMapping("/user/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody User user) {
		System.out.println(user);
		Map<String, Object> result = new HashMap<String, Object>();

		// User Service -> DAO -> DB //실제 유저인지 아닌지 확인 등등등....

		HttpStatus status = null;

		// User의 id가 Null이 아니거나 뭔가 작성이 되어있다면 로그인 성공 이라고 가정
		// 로그인 성공!
		try {
			if (user.getUserId() != null && user.getUserId().length() > 0) {
				// userDB가서 유저 확인해야함
				result.put("access-token", jwtUtil.createToken("id", user.getUserId()));
				result.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			}else {
				result.put("message", FAIL);
				status = HttpStatus.NO_CONTENT;
			}
		} catch (UnsupportedEncodingException e) {
			result.put("message", FAIL);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String,Object>>(result, status);
	}
}
