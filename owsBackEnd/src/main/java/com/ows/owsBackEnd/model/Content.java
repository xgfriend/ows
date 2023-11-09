package com.ows.owsBackEnd.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "contents") //
public class Content {
	
	@Id
	//DB에서 자동으로 기본 키 생성하도록 지정해 줌
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String loginId;
	@Column
	private String nickname;
	@Column
	private String text;
	@Column
	private String image;
	
	public Content() {
		super();
	}
	
	public Content(long id, String loginId, String nickname, String text, String image) {
		super();
		this.id = id;
		this.loginId = loginId;
		this.nickname = nickname;
		this.text = text;
		this.image = image;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
}
