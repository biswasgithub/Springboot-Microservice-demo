package com.mobileservice.service;

import java.util.List;

import com.mobileservice.entity.MobileEntity;

public interface MobileInterface {

	public List<MobileEntity> getAllMobile();
	
	public List<MobileEntity> getAllMobile(String mobile);
}
