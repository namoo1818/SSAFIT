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

import com.ssafit.board.model.dto.Review;
import com.ssafit.board.model.dto.SearchCondition;
import com.ssafit.board.model.service.ReviewService;

@RestController
@RequestMapping("/review")
public class ReviewRestController {
	// 응답을 편하게 하기 위해 상수로 지정
	private static final String SUCCESS = "succes";
	private static final String FAIL = "fail";

	@Autowired
	private ReviewService reviewService;

	// 1. 목록
	@GetMapping("")
	public ResponseEntity<?> list(SearchCondition condition) {
		List<Review> list = reviewService.search(condition);
		
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
	}

	// 2. 상세보기
	@GetMapping("/{id}")
	public ResponseEntity<Review> detail(@PathVariable int id) {
		Review review = reviewService.getReview(id);
		if (review != null)
			return new ResponseEntity<Review>(review, HttpStatus.OK);
		return new ResponseEntity<Review>(HttpStatus.NOT_FOUND);
	}

	// 3. 등록
	@PostMapping("")
	public ResponseEntity<Review> write(@RequestBody Review review) {
		reviewService.writeReview(review);
		return new ResponseEntity<Review>(review, HttpStatus.CREATED);
	}

	// 4. 삭제
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		if (reviewService.removeReview(id))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.NOT_FOUND);
	}

	// 5. 수정
	@PutMapping("")
	public ResponseEntity<String> update(@RequestBody Review review) {
		if (reviewService.modifyReview(review))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/video/{id}")
    public ResponseEntity<?> videoReview(@PathVariable int id){
        List<Review> list = reviewService.getVideoReveiw(id);
        if (list == null || list.size() == 0)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
    }

}
