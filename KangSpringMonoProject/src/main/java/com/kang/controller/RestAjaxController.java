package com.kang.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kang.bean.BuyTenderBean;
import com.kang.service.GeneralService;


@RestController
@RequestMapping("/authority")
public class RestAjaxController {
	private static final Logger logger = LoggerFactory.getLogger(SecurityController.class);
	@Autowired
	private GeneralService service;
	@Autowired
	private String uploadPath;
	@Autowired
	ServletContext context;
	
	
	@RequestMapping(value="/process", method = RequestMethod.POST)
	public ResponseEntity<String> process(MultipartFile file, Model model) throws Exception { 
		ResponseEntity<String> entity = null;
		if (file != null) {
			logger.info("file upload: " + file.getOriginalFilename());
			String saveFileName = null;
			try {
				saveFileName = uploadFile(file.getOriginalFilename(), file.getBytes());
				System.out.println("12312312312");
				int a = 123;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("1             :   "+ saveFileName);
			System.out.println("2             :   "+ file.getOriginalFilename());
			model.addAttribute("saveFileName", saveFileName);
			model.addAttribute("orgFileName", file.getOriginalFilename());
			entity = new ResponseEntity<String>(saveFileName, HttpStatus.OK);
		}else {
			entity = new ResponseEntity<String>("ERROR", HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	private String uploadFile(String orgFileName, byte[] fileData) 
		throws Exception {
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString() + "_" + orgFileName;
		
		String absoluteFilePath = context.getRealPath(uploadPath);
		File target = new File(absoluteFilePath, savedName);
		FileCopyUtils.copy(fileData, target);
		
		return savedName;
	}
	
	@RequestMapping(value="/idcheck", method=RequestMethod.POST) //입찰 유저에 내가 있는지 쳌
	public ResponseEntity<Integer> idCheck(@RequestParam("id") String id , @RequestParam("productNo") int productNo){
		ResponseEntity<Integer> entity = null;
		Map map = new HashMap();
		map.put("id", id);
		map.put("productNo", productNo);
		
		int ck = service.tenderIdCk(map);
		entity = new ResponseEntity<Integer>(ck,HttpStatus.OK);
		
		return entity;
	}
	@RequestMapping(value="/idsellcheck", method=RequestMethod.POST) //입찰 유저에 내가 있는지 쳌
	public ResponseEntity<Integer> idsellcheck(@RequestParam("id") String id , @RequestParam("sellProductNo") int sellProductNo){
		ResponseEntity<Integer> entity = null;
		Map map = new HashMap();
		map.put("id", id);
		map.put("sellProductNo", sellProductNo);
		
		int ck = service.sellTenderIdCk(map);
		entity = new ResponseEntity<Integer>(ck,HttpStatus.OK);
		
		return entity;
	}
	
}
