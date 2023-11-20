package com.ssafit.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.board.model.dto.SearchCondition;
import com.ssafit.board.model.dto.Video;
import com.ssafit.board.model.service.VideoService;

@RestController
@RequestMapping("/video")
@CrossOrigin(origins = "http://localhost:5173")
public class VideoRestController {
	// 응답을 편하게 하기 위해 상수로 지정
	private static final String SUCCESS = "succes";
	private static final String FAIL = "fail";

	@Autowired
	private VideoService videoService;

	// 1. 목록
	@GetMapping("")
	public ResponseEntity<?> list(SearchCondition condition) {
		List<Video> list = videoService.search(condition);
		
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
	}

	// 2. 상세보기
	@GetMapping("/{videoNum}")
	public ResponseEntity<Video> detail(@PathVariable int videoNum) {
		Video video = videoService.getVideo(videoNum);
		if (video != null)
			return new ResponseEntity<Video>(video, HttpStatus.OK);
		return new ResponseEntity<Video>(HttpStatus.NOT_FOUND);
	}

	// 3. 등록
	@PostMapping("")
	public ResponseEntity<Video> write(@RequestBody Video video) {
		videoService.writeVideo(video);
		return new ResponseEntity<Video>(video, HttpStatus.CREATED);
	}

	// 4. 삭제
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		if (videoService.removeVideo(id))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.NOT_FOUND);
	}

	// 5. 수정
	@PutMapping("")
	public ResponseEntity<String> update(@RequestBody Video video) {
		if (videoService.modifyVideo(video))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
	}

}
