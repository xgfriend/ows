package com.ows.owsBackEnd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ows.owsBackEnd.model.Archive;

public interface ArchiveRepository extends JpaRepository<Archive, Long> {
	//로그인 아이디로 저장 목록을 불러온다
	List<Archive> findByLoginId(String loginId);
}
