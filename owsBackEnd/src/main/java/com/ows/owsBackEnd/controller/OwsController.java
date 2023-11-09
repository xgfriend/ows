package com.ows.owsBackEnd.controller;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ows.owsBackEnd.model.Archive;
import com.ows.owsBackEnd.model.Content;
import com.ows.owsBackEnd.service.OwsService;

@RestController
@RequestMapping("/universe")
//출처가 다른 앱끼리 리소스를 공유하게끔 어노테이션 걸어 줌
//로컬 호스트 3000에서 우리의 접속을 허용하겠다라고 지정해 줌
@CrossOrigin(origins="http://localhost:3000", methods= {RequestMethod.GET, RequestMethod.POST})
public class OwsController {
	//OwsService를 변수 선언해서 사용하겠다
	private OwsService owsService;

// 이게 있으면 null로 값이 떠 버려서 우선 지움
//	public OwsController() {
//		super();
//	}

	public OwsController(OwsService owsService) {
		super();
		this.owsService = owsService;
	}
	
	//모든 컨텐트를 저장한다
	@PostMapping()
	public ResponseEntity<Content> saveContent(@RequestBody Content content) {
		return new ResponseEntity<Content>(
				owsService.saveContent(content), HttpStatus.CREATED);
	}
	
	//모든 컨텐트를 가지고 온다
	@GetMapping()
	public ResponseEntity<List<Content>> getAllContents() {
		return new ResponseEntity<List<Content>>(
				owsService.getAllContents(), HttpStatus.OK);
	}
	
	//id로 컨텐트를 가지고 온다
	@GetMapping("{id}")
	public ResponseEntity<Content> getContentById(@PathVariable long id) {
		return new ResponseEntity<Content>(
				owsService.getContentById(id), HttpStatus.OK);
	}
	
	//id로 컨텐트를 수정한다
	@PutMapping("{id}")
	public ResponseEntity<Content> updateGameById(
			@RequestBody Content content, @PathVariable long id) {
		return new ResponseEntity<Content>(
				owsService.updateContentById(content, id), HttpStatus.OK);				
	}
	
	//id로 컨텐트를 삭제한다
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteContentById(@PathVariable long id) {
		return new ResponseEntity<String>(
				"Successfully deleted!", HttpStatus.OK);
	}
	
	//저장 목록(archive)에 저장한다
	@PostMapping("archive")
	public ResponseEntity<Archive> saveArchive(@RequestBody Archive archive) {
		return new ResponseEntity<Archive>(
				owsService.saveArchive(archive), HttpStatus.OK);
	}
	
	//즐겨찾기한 저장 목록(list)을 불러온다 > 배열처리하는 건지 질문
	@PostMapping("archivelist")
	public ResponseEntity<List<Archive>> saveArchiveList(
			@RequestBody List<Archive> archiveList) {
		List<Archive> savedArchiveList = new ArrayList<Archive>();
		for (Archive archive : archiveList) {
			savedArchiveList.add(owsService.saveArchive(archive));
		}
		return new ResponseEntity<List<Archive>>(savedArchiveList, HttpStatus.OK);
	}
	
	//즐겨찾기된 모든 저장 목록(archive)을 불러온다
	@GetMapping("archive")
	public ResponseEntity<List<Archive>> getAllArchive() {
		return new ResponseEntity<List<Archive>>(
				owsService.getAllArchive(), HttpStatus.OK);
	}
	
	//해당 id에 저장된 저장 목록(list)를 불러온다
	@GetMapping("archive/{loginId}")
	public ResponseEntity<List<Archive>> getArchiveById(@PathVariable String loginId) {
		return new ResponseEntity<List<Archive>>(
				owsService.getArchiveById(loginId), HttpStatus.OK);
	}
	
}