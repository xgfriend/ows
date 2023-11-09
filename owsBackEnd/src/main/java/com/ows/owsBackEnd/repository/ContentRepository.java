package com.ows.owsBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ows.owsBackEnd.model.Content;

public interface ContentRepository extends JpaRepository<Content, Long> {

}
