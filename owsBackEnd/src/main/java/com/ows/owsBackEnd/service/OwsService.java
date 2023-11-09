package com.ows.owsBackEnd.service;

import java.util.List;

import com.ows.owsBackEnd.model.Archive;
import com.ows.owsBackEnd.model.Content;

public interface OwsService {
	
	//Content bean 안에 content를 저장한다 > Content 데이터타입 content 변수
	Content saveContent(Content content);
	//모든 컨텐츠을 불러옴
	List<Content> getAllContents();
	//컨텐트에서 컨텐트 id를 불러옴
	Content getContentById(long id);
    //id로 컨텐트를 추가하겠다
	Content updateContentById(Content content, long id);
	//id로 컨텐트를 삭제하겠다
	void deleteContentById(long id);
	//Archive bean 안에 archive를 저장한다
    Archive saveArchive(Archive archive);
    //Archive 리스트에서 모든 archive를 불러온다
    List<Archive> getAllArchive();
    //Archive 리스트에서 id로 아카이브를 불러온다
    List<Archive> getArchiveById(String loginId);
	}