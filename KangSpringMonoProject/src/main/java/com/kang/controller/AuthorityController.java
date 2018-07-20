package com.kang.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

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
import com.kang.bean.BuyTenderBean;
import com.kang.bean.SellBoardBean;
import com.kang.bean.SellTenderBean;
import com.kang.bean.User;
import com.kang.service.GeneralService;

@Controller
@RequestMapping("/authority")
public class AuthorityController {
	private static final int PAGE_GROUP = 5; 
	@Autowired
	private GeneralService service;
	private static final Logger logger = LoggerFactory.getLogger(SecurityController.class);
	@Autowired
	private String uploadPath;
	@Autowired
	ServletContext context;
	@RequestMapping(value="/myinfo", method=RequestMethod.GET) //내정보로 이동
	public String myinfo(Principal principal) {
		service.myinfo(principal.getName());
		return "page/myinfo";
	}
	@RequestMapping(value="/buy", method=RequestMethod.GET) // 구매 게시판
	public String buy(@RequestParam(value="pageNum",required=false) String pageNum, Model model) {
		List<BuyBoardBean> list = null;
		/* 페이지 넘버 가져옴 위에 RequestParam을 required=false 를 해야 에러 안남 required=false 뜻 => 있어도 되고 없어도 된다는 뜻 */
		if(pageNum == null) {
			pageNum = "1";
		}
		int pageNumber = Integer.parseInt(pageNum);
		int productCount = service.productBuyCount(); //구매 게시판의 전체 글 갯수
		int start = (pageNumber -1) * PAGE_GROUP; //가져올 시작번호
		
		Map map = new HashMap();
		map.put("start", start);
		map.put("pageGroup", PAGE_GROUP);
		if(productCount > 0) { //일정이 있으면
		 list = service.productBuyList(map); //맵으로 바꾸자
		}
		//정상 : listCount , listPg, startPg
		//리스트 페이지수 계산 
		int  listPg  =  productCount  /  PAGE_GROUP +  (productCount %  PAGE_GROUP  ==  0  ?  0  :  1);
		int startPg = (pageNumber / PAGE_GROUP) * PAGE_GROUP + 1 - (pageNumber %  PAGE_GROUP  ==  0  ?  PAGE_GROUP  :  0);
		int endPg = startPg + PAGE_GROUP -1;
		if(endPg > listPg) {
			endPg = listPg;
		}
		
		model.addAttribute("pageNum", pageNumber); //요청 페이지 숫자
		model.addAttribute("productCount", productCount); //해당아이디의 투두의 전체갯수
		model.addAttribute("productBuyList", list); //해당아이디의 투두
		model.addAttribute("listPg", listPg); //페이지 전체수
		model.addAttribute("startPg", startPg);
		model.addAttribute("endPg", endPg);
		model.addAttribute("pageGroup", PAGE_GROUP);
		
		System.out.println("상품의 갯수 : " +productCount);
		
		System.out.println("List size " +list);
		
		return "page/productBuyBoard";
	}
	@RequestMapping(value="/sell", method=RequestMethod.GET) //판매 게시판
	public String sell(@RequestParam(value="pageNum",required=false) String pageNum, Model model) {
		List<SellBoardBean> list = null;
		/* 페이지 넘버 가져옴 위에 RequestParam을 required=false 를 해야 에러 안남 required=false 뜻 => 있어도 되고 없어도 된다는 뜻 */
		if(pageNum == null) {
			pageNum = "1";
		}
		int pageNumber = Integer.parseInt(pageNum);
		int productCount = service.productSellCount(); //구매 게시판의 전체 글 갯수
		int start = (pageNumber -1) * PAGE_GROUP; //가져올 시작번호
		
		Map map = new HashMap();
		map.put("start", start);
		map.put("pageGroup", PAGE_GROUP);
		if(productCount > 0) { //일정이 있으면
		 list = service.productSellList(map); //맵으로 바꾸자
		}
		//정상 : listCount , listPg, startPg
		//리스트 페이지수 계산 
		int  listPg  =  productCount  /  PAGE_GROUP +  (productCount %  PAGE_GROUP  ==  0  ?  0  :  1);
		int startPg = (pageNumber / PAGE_GROUP) * PAGE_GROUP + 1 - (pageNumber %  PAGE_GROUP  ==  0  ?  PAGE_GROUP  :  0);
		int endPg = startPg + PAGE_GROUP -1;
		if(endPg > listPg) {
			endPg = listPg;
		}
		
		model.addAttribute("pageNum", pageNumber); //요청 페이지 숫자
		model.addAttribute("productCount", productCount); //해당아이디의 투두의 전체갯수
		model.addAttribute("productSellList", list); //해당아이디의 투두
		model.addAttribute("listPg", listPg); //페이지 전체수
		model.addAttribute("startPg", startPg);
		model.addAttribute("endPg", endPg);
		model.addAttribute("pageGroup", PAGE_GROUP);
		
		System.out.println("상품의 갯수 : " +productCount);
		
		System.out.println("List size " +list);
		
		return "page/productSellBoard";
	}
	@RequestMapping(value="/buyhagi" , method= RequestMethod.GET) // 구매등록 폼으로 이동
	public String buyhagif() {
		return "page/productBuyF";
	}
	@RequestMapping(value="/sellhagi" , method= RequestMethod.GET) // 판매 등록 폼으로 이동
	public String sellhagif() {
		return "page/productSellF";
	}
	
	@RequestMapping(value="/buyinsert" , method= RequestMethod.POST) // 구매 등록
	public String buyInsert(@ModelAttribute("buyBoard") BuyBoardBean buyBoardBean,Principal principal) {
		System.out.println(buyBoardBean.toString());
		buyBoardBean.setId(principal.getName());
		service.productBuyInsert(buyBoardBean);
		return "home";
	}
	
	@RequestMapping(value="/sellinsert" , method=RequestMethod.POST) // 판매 등록
	public String sellInsert(@ModelAttribute("selBoard") SellBoardBean sellBoardBean, Principal principal) {
		System.out.println(sellBoardBean.toString());
		sellBoardBean.setId(principal.getName());
		service.productSellInsert(sellBoardBean);
		return "home";
	}
	
	@RequestMapping(value="/productBuyInfo",method=RequestMethod.GET) // 구매게시판 각 상품 정보 이동
	public String productInfo(@RequestParam("productNo") int productNo, @RequestParam("cano") int cano, Principal principal, Model model){		
		BuyBoardBean buyInfo = service.productBuyInfo(productNo);
		User user = service.myinfo(principal.getName());
		String caName = service.getCategoryName(cano);
		model.addAttribute("buyInfo", buyInfo);
		model.addAttribute("caName", caName);
		model.addAttribute("userm", user);
		List<BuyTenderBean> list = null;
		list = service.getBuyTenderList(productNo);

		model.addAttribute("tender", list);
		return "page/productBuyInfo";
	}
	
	@RequestMapping(value="/point", method=RequestMethod.GET) // 포인트 충전 품으로 이동
	public String point() {
		return "page/pointF";
	}
	@RequestMapping(value="/pointProcess", method=RequestMethod.POST) // 포인트 충전
	public String pointProcess(@RequestParam("point") int point, Principal principal) {
		Map map = new HashMap();
		map.put("point", point);
		map.put("id", principal.getName());
		service.pointUpdate(map);
		return "redirect:/authority/pointSuccessProcess";
	}
	@RequestMapping(value="/pointSuccessProcess", method=RequestMethod.GET) // 포인트 성공 
	public String pointSuccessProcess() {
		return "page/pointP";
	}
	
	@RequestMapping(value="/tenderBuyInsert", method=RequestMethod.POST) // 입찰 등록 인서트
	public String tenderBuyInsert(@ModelAttribute("tender") BuyTenderBean buyTenderBean, @RequestParam("cano") int cano, Principal principal) {
		buyTenderBean.setId(principal.getName());
		service.insertBuyTender(buyTenderBean);
		return "redirect:/authority/productBuyInfo?productNo="+buyTenderBean.getProductNo()+"&cano="+cano;
	}
	
	@RequestMapping(value="/tenderBuyUpdate", method=RequestMethod.POST) // 입찰 수정 업데이트
	public String tenderBuyUpdate(@ModelAttribute("tender") BuyTenderBean buyTenderBean, @RequestParam("cano") int cano, Principal principal){
		buyTenderBean.setId(principal.getName());
		service.updateBuyTender(buyTenderBean);
		return "redirect:/authority/productBuyInfo?productNo="+buyTenderBean.getProductNo()+"&cano="+cano;
	}
	
	
	
	
	@RequestMapping(value="/tenderSellInsert", method=RequestMethod.POST) // 입찰 등록 인서트
	public String tenderBuyInsert(@ModelAttribute("tender") SellTenderBean sellTenderBean, @RequestParam("cano") int cano, Principal principal) {
		sellTenderBean.setId(principal.getName());
		service.insertSellTender(sellTenderBean);
		return "redirect:/authority/productSellInfo?sellProductNo="+sellTenderBean.getSellProductNo()+"&cano="+cano;
	}

	@RequestMapping(value="/productSellInfo",method=RequestMethod.GET)
	public String productSellInfo(@RequestParam("sellProductNo") int sellProductNo, @RequestParam("cano") int cano,Principal principal, Model model) {
		SellBoardBean sellInfo = service.productSellInfo(sellProductNo);
		User user = service.myinfo(principal.getName());
		String caName = service.getCategoryName(cano);
		model.addAttribute("sellInfo", sellInfo);
		model.addAttribute("caName", caName);
		model.addAttribute("userm",user);
		List<SellTenderBean> list = null;
		list = service.getSellTenderList(sellProductNo);
		
		model.addAttribute("tender", list);
		return "page/productSellInfo";
	}
	
	@RequestMapping(value="/tenderSellUpdate", method=RequestMethod.POST) // 입찰 수정 업데이트
	public String tenderSellUpdate(@ModelAttribute("tender") SellTenderBean sellTenderBean, @RequestParam("cano") int cano, Principal principal){
		sellTenderBean.setId(principal.getName());
		service.updateSellTender(sellTenderBean);
		return "redirect:/authority/productSellInfo?sellProductNo="+sellTenderBean.getSellProductNo()+"&cano="+cano;
	}
	
	@RequestMapping(value="/myselllist", method=RequestMethod.GET)
	public String mySellList(Principal principal, Model model){
		List<SellBoardBean> mySellList = service.mySellList(principal.getName());
		model.addAttribute("mySellList",mySellList);
		return "page/mySellInfo";
	}
	
	@RequestMapping(value="/mybuylist", method=RequestMethod.GET)
	public String myBuyList(Principal principal, Model model){
		List<BuyBoardBean> myBuyList = service.myBuyList(principal.getName());
		model.addAttribute("myBuyList",myBuyList);
		return "page/myBuyInfo";
	}
	
	//?????
	@RequestMapping(value="/myTenders", method=RequestMethod.GET)
	public String myTenders(Principal principal, Model model){
		List<SellBoardBean> mySellTenderList = service.mySellTenderList(principal.getName());
		model.addAttribute("mySellTenderList",mySellTenderList);
		List<BuyBoardBean> myBuyTenderList = service.myBuyTenderList(principal.getName());
		model.addAttribute("myBuyTenderList",myBuyTenderList);
		return "page/myTenderList";
	}
	
	@RequestMapping(value="/buyResult" , method=RequestMethod.GET)
	public String buyResult2(@RequestParam("productNo") int productNo, @RequestParam("tenderId") String tenderId, Model model){
		
		BuyBoardBean bean = service.productBuyInfo(productNo);
		
		Map map2 = new HashMap();
		map2.put("productNo", productNo);
		map2.put("id", tenderId);
		BuyTenderBean bean2 = service.tenderUserInfo(map2);
		
		model.addAttribute("bean" , bean); //물품 정보
		model.addAttribute("bean2", bean2); //수락한 입찰 정보
		
		return "page/buyResult";
	}
	
	@RequestMapping(value="/buyResult" , method=RequestMethod.POST)
	public String buyResult(@RequestParam("productNo") int productNo, @RequestParam("tenderId") String tenderId, Model model){
		Map map = new HashMap();
		map.put("productNo", productNo);
		map.put("complete", "거래중");
		map.put("tenderPerson",tenderId);
		service.updateBuyResult(map);
		
		BuyBoardBean bean = service.productBuyInfo(productNo);
		
		
		
		Map map2 = new HashMap();
		map2.put("productNo", productNo);
		map2.put("id", tenderId);
		BuyTenderBean bean2 = service.tenderUserInfo(map2);
		
		model.addAttribute("bean" , bean); //물품 정보
		model.addAttribute("bean2", bean2); //수락한 입찰 정보
		
		return "page/buyResult";
	}
	@RequestMapping(value="/sellResult" , method=RequestMethod.POST) // 내가 판매자
	public String sellResult(@RequestParam("sellProductNo") int sellProductNo, @RequestParam("tenderId") String tenderId, Model model){
		Map map = new HashMap();
		map.put("sellProductNo", sellProductNo);
		map.put("complete", "거래중");
		map.put("tenderPerson",tenderId);
		service.updateSellResult(map);
		System.out.println("|||||||||||||||||||||||||||||" + tenderId);
		SellBoardBean bean = service.productSellInfo(sellProductNo);
		
		Map map3 = new HashMap();
		map3.put("status", "거래중");
		map3.put("sellProductNo", sellProductNo);
		map3.put("id",tenderId);
		service.updateSellTenderStatus(map3);
		
		Map map2 = new HashMap();
		map2.put("sellProductNo", sellProductNo);
		map2.put("id", tenderId);
		SellTenderBean bean2 = service.tenderSellUserInfo(map2);
		
		model.addAttribute("bean" , bean); //물품 정보
		model.addAttribute("bean2", bean2); //수락한 입찰 정보
		
		return "page/sellResult";
	}
	@RequestMapping(value="/sellResult" , method=RequestMethod.GET) //내가 판매자
	public String sellResult2(@RequestParam("sellProductNo") int sellProductNo, @RequestParam("tenderId") String tenderId, Model model){
		
		SellBoardBean bean = service.productSellInfo(sellProductNo);
		
		Map map3 = new HashMap();
		map3.put("status", "거래중");
		map3.put("sellProductNo", sellProductNo);
		map3.put("id",tenderId);
		service.updateSellTenderStatus(map3);
		
		Map map2 = new HashMap();
		map2.put("sellProductNo", sellProductNo);
		map2.put("id", tenderId);
		SellTenderBean bean2 = service.tenderSellUserInfo(map2);
		
		model.addAttribute("bean" , bean); //물품 정보
		model.addAttribute("bean2", bean2); //수락한 입찰 정보
		
		return "page/sellResult";
	}
	
	@RequestMapping(value="/sellResult2" , method=RequestMethod.GET) // 입찰자
	public String sellResult3(@RequestParam("sellProductNo") int sellProductNo, @RequestParam("tenderId") String tenderId, Model model){
		
		SellBoardBean bean = service.productSellInfo(sellProductNo);
		
		Map map3 = new HashMap();
		map3.put("status", "거래중");
		map3.put("sellProductNo", sellProductNo);
		map3.put("id",tenderId);
		service.updateSellTenderStatus(map3);
		
		Map map2 = new HashMap();
		map2.put("sellProductNo", sellProductNo);
		map2.put("id", tenderId);
		SellTenderBean bean2 = service.tenderSellUserInfo(map2);
		
		model.addAttribute("bean" , bean); //물품 정보
		model.addAttribute("bean2", bean2); //수락한 입찰 정보
		
		return "page/sellResult2";
	}
	
	@RequestMapping(value="/sellResult2Ok", method=RequestMethod.POST)
	public String sellResult2Ok(@RequestParam("sellTenderNo") int sellTenderNo){
		service.updateSellTenderStatus(sellTenderNo);
		return "";
	}
	
	@RequestMapping(value="/sellResultOk",method=RequestMethod.POST)
	public String sellResultOk(@RequestParam("sellProductNo") int sellProductNo){
		service.updateSellProduct(sellProductNo);
		return "";
	}
}
