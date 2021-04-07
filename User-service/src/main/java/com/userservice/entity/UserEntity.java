package com.userservice.entity;

public class UserEntity {

	private String name;
	private int id;
	private MobileResponse userMobiles;
	
	public UserEntity() {
		super();
	}
	
	public UserEntity(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	public UserEntity(String name, int id, MobileResponse userMobiles) {
		super();
		this.name = name;
		this.id = id;
		this.userMobiles = userMobiles;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public MobileResponse getUserMobiles() {
		return userMobiles;
	}

	public void setUserMobiles(MobileResponse userMobiles) {
		this.userMobiles = userMobiles;
	}
	
	
	
}
