package com.ows.owsBackEnd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ows.owsBackEnd.model.Archive;
import com.ows.owsBackEnd.model.Content;
import com.ows.owsBackEnd.repository.ArchiveRepository;
import com.ows.owsBackEnd.repository.ContentRepository;
import com.ows.owsBackEnd.service.OwsService;


@Service
public class OwsServiceImpl implements OwsService {
	
		private ContentRepository contentRepository;
		private ArchiveRepository archiveRepository;
		
		@Autowired
		public OwsServiceImpl(ContentRepository contentRepository, ArchiveRepository archiveRepository) {
			super();
			this.contentRepository = contentRepository;
			this.archiveRepository = archiveRepository;
		}
		
		@Override
		public Content saveContent(Content content) {
			return contentRepository.save(content);
		}

		@Override
		public List<Content> getAllContents() {
			return contentRepository.findAll();
		}

		@Override
		public Content getContentById(long id) {
			return contentRepository.findById(id).orElseThrow(()->null);
		}

		@Override
		public Content updateContentById(Content content, long id) {
			Content existingContent = contentRepository.findById(id).orElseThrow(()->null);
			existingContent.setLoginId(content.getLoginId());
			existingContent.setImage(content.getImage());
			existingContent.setNickname(content.getNickname());
			existingContent.setText(content.getText());
			contentRepository.save(existingContent);
			return existingContent;
		}

		@Override
		public void deleteContentById(long id) {
			contentRepository.findById(id).orElseThrow(()->null);
			contentRepository.deleteById(id);
		}

		@Override
		public Archive saveArchive(Archive archive) {
			return archiveRepository.save(archive);
		}

		@Override
		public List<Archive> getAllArchive() {
			return archiveRepository.findAll();
		}

		@Override
		public List<Archive> getArchiveById(String loginId) {
			return archiveRepository.findByLoginId(loginId);
		}

	
}