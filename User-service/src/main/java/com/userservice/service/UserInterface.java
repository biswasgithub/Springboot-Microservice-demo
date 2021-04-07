package com.userservice.service;

import com.userservice.entity.UserEntity;

public interface UserInterface {

	public UserEntity getUserdetails();
	public UserEntity gerUserMobile();
	public UserEntity gerUserMobile(String mobile);
	public UserEntity postUserMobile(String mobile);
}
