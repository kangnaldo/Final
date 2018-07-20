package com.kang.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kang.bean.BuyBoardBean;
import com.kang.bean.BuyTenderBean;
import com.kang.bean.SellBoardBean;
import com.kang.bean.SellTenderBean;
import com.kang.bean.User;
import com.kang.dao.GeneralDao;

@Service
public class GeneralServiceImpl implements GeneralService {
	
	@Autowired
	private GeneralDao dao;
	
	@Override
	public void register(User user) {
		dao.register(user);
	}

	@Override
	public void login(User user) {
		dao.login(user);
	}

	@Override
	public User myinfo(String id) {
		return dao.myinfo(id);
	}

	@Override
	public int productBuyCount() {
		return dao.productBuyCount();
	}

	@Override
	public List<BuyBoardBean> productBuyList(Map map) {
		// TODO Auto-generated method stub
		return dao.productBuyList(map);
	}

	@Override
	public void productBuyInsert(BuyBoardBean buyBoardBean) {
		// TODO Auto-generated method stub
		dao.productBuyInsert(buyBoardBean);
		
	}

	@Override
	public void productSellInsert(SellBoardBean sellBoardBean) {
		dao.productSellInsert(sellBoardBean);
	}

	@Override
	public int productSellCount() {
		return dao.productSellCount();
	}

	@Override
	public List<SellBoardBean> productSellList(Map map) {
		return dao.productSellList(map);
	}

	@Override
	public BuyBoardBean productBuyInfo(int productNo) {
		return dao.productBuyInfo(productNo);
	}

	@Override
	public String getCategoryName(int cano) {
		return dao.getCategoryName(cano);
	}
	
	@Override
	public List<BuyTenderBean> getBuyTenderList(int productNo) {
		// TODO Auto-generated method stub
		return dao.getBuyTenderList(productNo);
	}

	@Override
	public void pointUpdate(Map map) {
		dao.pointUpdate(map);
	}

	@Override
	public void insertBuyTender(BuyTenderBean buyTenderBean) {
		dao.insertBuyTender(buyTenderBean);
	}

	@Override
	public int tenderIdCk(Map map) {
		return dao.tenderIdCk(map);
	}

	@Override
	public void updateBuyTender(BuyTenderBean buyTenderBean) {
		dao.updateBuyTender(buyTenderBean);
	}

	@Override
	public BuyTenderBean tenderUserInfo(Map map) {
		return dao.tenderUserInfo(map);
	}

	@Override
	public SellBoardBean productSellInfo(int sellProductNo) {
		return dao.productSellInfo(sellProductNo);
	}

	@Override
	public List<SellTenderBean> getSellTenderList(int sellProductNo) {
		return dao.getSellTenderList(sellProductNo);
	}

	@Override
	public int sellTenderIdCk(Map map) {
		return dao.sellTenderIdCk(map);
	}

	@Override
	public void updateSellTender(SellTenderBean sellTenderBean) {
		dao.updateSellTender(sellTenderBean);
	}

	@Override
	public void insertSellTender(SellTenderBean sellTenderBean) {
		dao.insertSellTender(sellTenderBean);
	}

	@Override
	public List<SellBoardBean> mySellList(String id) {
		return dao.mySellList(id);
	}

	@Override
	public List<BuyBoardBean> myBuyList(String id) {
		return dao.myBuyList(id);
	}

	@Override
	public List<SellBoardBean> mySellTenderList(String id) {
		return dao.mySellTenderList(id);
	}

	@Override
	public List<BuyBoardBean> myBuyTenderList(String id) {
		return dao.myBuyTenderList(id);
	}

	@Override
	public List<BuyBoardBean> buyBoards() {
		return dao.buyBoards();
	}

	@Override
	public List<SellBoardBean> sellBoards() {
		return dao.sellBoards();
	}

	@Override
	public void updateBuyResult(Map map) {
		dao.updateBuyResult(map);
	}

	@Override
	public void updateSellResult(Map map) {
		dao.updateSellResult(map);
	}

	@Override
	public SellTenderBean tenderSellUserInfo(Map map) {
		return dao.tenderSellUserInfo(map);
	}

	@Override
	public void updateSellTenderStatus(Map map) {
		dao.updateSellTenderStatus(map);
	}

	@Override
	public void updateSellTenderStatus(int sellTenderNo) {
		dao.updateSellTenderStatus(sellTenderNo);
	}

	@Override
	public void updateSellProduct(int sellProductNo) {
		dao.updateSellProduct(sellProductNo);
	}

}
