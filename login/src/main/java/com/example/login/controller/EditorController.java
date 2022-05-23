package com.example.login.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.login.model.BlogInfo;
import com.example.login.repository.BlogInfoRepository;



@Controller
public class EditorController {

	@Autowired
	private BlogInfoRepository BlogInfoRepository;
	
	@GetMapping("/editor")
	public String getEditorView() {
		return "editor";
	}

	@PostMapping("/editor")
	public ModelAndView editor(//
			@RequestParam("username") String username, //
			@RequestParam("title") String title, //
			@RequestParam("introduction") String introduction, //
			@RequestParam("story") String story,//
			ModelAndView mv) {
		
		/*if(!password.equals(passwordAgain)) {
			mv.setViewName("fail");
		}else {*/
		
		
		//UserInfo userInfo = new UserInfo(); //new一个对象
		BlogInfo blogInfo = BlogInfo.builder().name(username).title(title).introducton(introduction).story(story).build(); //lombok写法
		
		BlogInfoRepository.save(blogInfo);
		
		mv.addObject("username",username);
		mv.setViewName("homepage");
		
		/* } */
		return mv;
	}

}