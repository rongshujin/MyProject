package com.example.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.login.model.UserInfo;
import com.example.login.repository.UserInfoRepository;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginController {
	
	@Autowired
	private UserInfoRepository userInfoRepository;  //对interface实例化
	

	@GetMapping("/login")
	public String getLoginView() {
		log.debug("aaa");
		return "login"; //默认返回的是html文件 后缀可以省略
	}

	@PostMapping("/login")
	public ModelAndView login(@RequestParam ("username") String username /*对应的是form表单里的name属性*/, 
			@RequestParam ("password") String password, 
			ModelAndView mv) {

		mv.addObject("username", username);
		
		UserInfo userInfo = userInfoRepository.findByName(username); //传数据库
		
		if (userInfo != null && password.equals(userInfo.getPassword())) {  //输入的username不存在的话也返回fail
			mv.setViewName("homepage");
		} else {
				// return "success";
				// return "fail";
				mv.setViewName("register");
			}

			return mv;
		
		}
	
	@GetMapping("/homepage")
	public String getSuccessView() {
		return "homepage";
	}
}
