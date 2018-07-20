package com.kang.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kang.bean.BuyBoardBean;
import com.kang.bean.BuyTenderBean;
import com.kang.bean.SellBoardBean;
import com.kang.bean.SellTenderBean;
import com.kang.bean.User;

@Repository
public class GeneralDaoImpl implements GeneralDao {
	
	private static final String namespace = "com.kang.mapper.TaeukMapper";
	
	@Autowired
	private SqlSession session;
	
	@Override
	public void register(User user) {
		session.insert(namespace + ".register", user); 
	}

	@Override
	public void login(User user) {
		session.selectOne(namespace + ".login", user);
	}

	@Override
	public User myinfo(String id) {
		return session.selectOne(namespace + ".myinfo", id);
	}

	@Override
	public int productBuyCount() {
		return session.selectOne(namespace + ".productBuyCount");
	}

	@Override
	public List<BuyBoardBean> productBuyList(Map map) {
		// TODO Auto-generated method stub
		return session.selectList(namespace +".productBuyList" , map);
	}

	@Override
	public void productBuyInsert(BuyBoardBean buyBoardBean) {
		session.insert(namespace+".productBuyInsert",buyBoardBean);
	}

	@Override
	public void productSellInsert(SellBoardBean sellBoardBean) {
		session.insert(namespace +".productSellInsert",sellBoardBean);
	}

	@Override
	public int productSellCount() {
		return session.selectOne(namespace + ".productSellCount");
	}

	@Override
	public List<SellBoardBean> productSellList(Map map) {
		// TODO Auto-generated method stub
		return session.selectList(namespace +".productSellList" , map);
	}

	@Override
	public BuyBoardBean productBuyInfo(int productNo) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace +".productBuyInfo", productNo);
	}

	@Override
	public String getCategoryName(int cano) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".getCategoryName", cano);
	}

	@Override
	public List<BuyTenderBean> getBuyTenderList(int productNo) {
		return session.selectList(namespace +".getBuyTender", productNo);
	}

	@Override
	public void pointUpdate(Map map) {
		session.update(namespace +".pointUpdate", map);
	}

	@Override
	public void insertBuyTender(BuyTenderBean buyTenderBean) {
		session.insert(namespace+".buyTenderInsert", buyTenderBean);
	}

	@Override
	public int tenderIdCk(Map map) {
		return session.selectOne(namespace +".tenderCk",map);
	}

	@Override
	public void updateBuyTender(BuyTenderBean buyTenderBean) {
		session.update(namespace +".buyTenderUpdate",buyTenderBean);
	}

	

	@Override
	public SellBoardBean productSellInfo(int sellProductNo) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace +".productSellInfo" , sellProductNo);
	}

	@Override
	public List<SellTenderBean> getSellTenderList(int sellProductNo) {
		return session.selectList(namespace + ".getSellTender" , sellProductNo);
	}

	@Override
	public int sellTenderIdCk(Map map) {
		return session.selectOne(namespace +".selltenderCk",map);
	}

	@Override
	public void updateSellTender(SellTenderBean sellTenderBean) {
		session.update(namespace +".sellTenderUpdate",sellTenderBean);
	}

	@Override
	public void insertSellTender(SellTenderBean sellTenderBean) {
		session.insert(namespace +".sellTenderInsert",sellTenderBean);
	}

	@Override
	public List<SellBoardBean> mySellList(String id) {
		return session.selectList(namespace +".mySellList",id);
	}

	@Override
	public List<BuyBoardBean> myBuyList(String id) {
		return session.selectList(namespace +".myBuyList",id);
	}

	@Override
	public List<SellBoardBean> mySellTenderList(String id) {
		// TODO Auto-generated method stub
		return session.selectList(namespace +".mySellTenderList",id);
	}

	@Override
	public List<BuyBoardBean> myBuyTenderList(String id) {
		return session.selectList(namespace +".myBuyTenderList",id);
	}

	@Override
	public List<BuyBoardBean> buyBoards() {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".buyBoards");
	}

	@Override
	public List<SellBoardBean> sellBoards() {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".sellBoards");
	}

	@Override
	public void updateBuyResult(Map map) {
		session.update(namespace +".buyResult" ,map);
	}
	
	@Override
	public BuyTenderBean tenderUserInfo(Map map) {
		return session.selectOne(namespace +".tenderUserInfo",map);
	}

	@Override
	public void updateSellResult(Map map) {
		session.update(namespace+".sellResult",map);
	}

	@Override
	public SellTenderBean tenderSellUserInfo(Map map) {
		return session.selectOne(namespace +".tenderSellUserInfo", map);
	}

	@Override
	public void updateSellTenderStatus(Map map) {
		session.update(namespace +".sellTenderStatusUpdate", map);
	}

	@Override
	public void updateSellTenderStatus(int sellTenderNo) {
		session.update(namespace +".sellTenderStatusUpdate2",sellTenderNo);
	}

	@Override
	public void updateSellProduct(int sellProductNo) {
		session.update(namespace +".sellProductUpdate",sellProductNo);
	}
}
