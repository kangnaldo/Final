package com.kang.controller;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kang.bean.BuyBoardBean;
import com.kang.bean.User;
import com.kang.service.GeneralService;


@Controller
public class GeneralController {
	
	@Autowired
	private GeneralService service;
	
	private static final Logger logger = LoggerFactory.getLogger(GeneralController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		/*List<BuyBoardBean> buyBean = service.buyBoards();
		model.addAttribute("buyBean" ,buyBean);*/
		return "home";
	}
	
	@RequestMapping(value = "/design", method = RequestMethod.GET)
	public String design(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "design";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String register(@RequestParam("addr1") String addr1, @RequestParam("addr2") String addr2
			,@RequestParam("addr3") String addr3,@ModelAttribute User user) {
		user.setAddr(addr1+","+addr2+","+addr3);
	
		service.register(user);
		return "redirect:/";
	}
	
	@RequestMapping(value="/registerSuccess", method=RequestMethod.GET)
	public String registerSuccess() {
		logger.info("회원가입 성공 페이징");
		return "/process/registerSuccess";
	}
	
	@RequestMapping(value="/login" , method=RequestMethod.POST)
	public String login(@ModelAttribute("user") User user) {
		service.login(user);
		return "/";
	}
}
