package com.kang.dao;

import java.util.List;
import java.util.Map;

import com.kang.bean.BuyBoardBean;
import com.kang.bean.BuyTenderBean;
import com.kang.bean.SellBoardBean;
import com.kang.bean.SellTenderBean;
import com.kang.bean.User;

public interface GeneralDao {
	public void register(User user); //회원가입
	public void login(User user); //로귄
	public User myinfo(String id); // 개인정보
	public int productBuyCount(); //  구매 총 개수
	public List<BuyBoardBean> productBuyList(Map map); // 구매 총 물품
	public void productBuyInsert(BuyBoardBean buyBoardBean); // 구매 인서트
	public void productSellInsert(SellBoardBean sellBoardBean); // 판매 인서트
	public int productSellCount(); // 판매 총개수
	public List<SellBoardBean> productSellList(Map map); // 판매 총 물품 
	public BuyBoardBean productBuyInfo(int productNo); // 구매 상품 정보로 GO
	public String getCategoryName(int cano); // 카테고리 네임 가꼬오기
	public List<BuyTenderBean> getBuyTenderList(int productNo); //해당 상품 입찰 리스트 가꼬오기
	public void pointUpdate(Map map); //포인트 충전
	public void insertBuyTender(BuyTenderBean buyTenderBean); //구매 입찰 등록
	public int tenderIdCk(Map map); // 해당 상품의 입찰 했는지 안했는지 확인
	public void updateBuyTender(BuyTenderBean buyTenderBean); //구매 입찰 수정
	public BuyTenderBean tenderUserInfo(Map map); //해당 물품 구매 입찰 정보
	public SellBoardBean productSellInfo(int sellProductNo); // 판매 상품 정보로 GO
	public List<SellTenderBean> getSellTenderList(int sellProductNo); //판매 입찰 리스트
	public int sellTenderIdCk(Map map); // 해당상품의 판매 입찰 했는지 안했는지 확인
	public void updateSellTender(SellTenderBean sellTenderBean); //판매 입찰 수정
	public void insertSellTender(SellTenderBean sellTenderBean); //판매 입찰 등록
	public List<SellBoardBean> mySellList(String id); // 나의 판매 리스트
	public List<BuyBoardBean> myBuyList(String id); // 내 구매 리스트
	public List<SellBoardBean> mySellTenderList(String id); //판매 입찰한 물품 리스트
	public List<BuyBoardBean> myBuyTenderList(String id); // 구매 입찰한 물품 리스트
	public List<BuyBoardBean> buyBoards(); //buyboard 전체 가져오기
	public List<SellBoardBean> sellBoards(); //sellboard 전체 가져오기
	public void updateBuyResult(Map map); // completion 상태 업데이트 
	public void updateSellResult(Map map); // sell completion 상태 업데이트
	public SellTenderBean tenderSellUserInfo(Map map); //판매입찰 수락한 상대방 정보
	public void updateSellTenderStatus(Map map); // 판매 입찰 스테이스 변경 
	public void updateSellTenderStatus(int sellTenderNo); //(입찰자) 판매 수락후 입찰 스테이스 변경
	public void updateSellProduct(int sellProductNo); //(판매등록자) 판매 수락후 상품 스테이스 변경
}
