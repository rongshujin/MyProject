package com.example.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.login.model.BlogInfo;

public interface BlogInfoRepository extends JpaRepository<BlogInfo,Long>{
	
	BlogInfo findByName(String name); //定义findbyname方法 
	
}