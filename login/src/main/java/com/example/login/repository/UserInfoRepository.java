package com.example.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.login.model.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo,Long>{
	
	UserInfo findByName(String name); //定义findbyname方法 
	
}