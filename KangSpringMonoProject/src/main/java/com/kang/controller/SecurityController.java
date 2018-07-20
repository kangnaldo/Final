package com.kang.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kang.bean.BuyBoardBean;
import com.kang.service.GeneralService;

@Controller
public class SecurityController {
	private static final Logger logger = LoggerFactory.getLogger(SecurityController.class);
	@Autowired
	private GeneralService service;
	@RequestMapping("/login") // 페이지를 뿌려준당
	public String login(Locale locale, Model model) {
	
		logger.info("login get called");
	
		return "home";
	}


	@RequestMapping("/error")
	public String error(Locale locale, Model model) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("error", "로그인 실패, 잘못된 ID/PASSWORD입니다");

		return "home";
	}
}
