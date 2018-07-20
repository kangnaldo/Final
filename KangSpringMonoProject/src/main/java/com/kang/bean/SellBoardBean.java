package com.kang.bean;

import java.sql.Timestamp;
import java.util.ArrayList;

public class SellBoardBean {
	private String subject; //제목
	private String content; //내용
	private String id; //아이디
	private String sellProductNo; //상품번호
	private String productName; // 상품이름
	private Timestamp createDate; //생성일
	private String endDate; //마감
	private int cnt; // 조회수
	private int cano; // 카테고리
	private double let; // 위도
	private double longs; //경도
	private int level; //맵레벨
	private String place; // 장소
	private int price; //최소 가격
	private String tm; //거래방법
	private String img; //이미지 이름
	private String complete; // 거래 완료 여부
	
	private SellTenderBean sellTenders;
	private String tenderPerson;
	
	public String getTenderPerson() {
		return tenderPerson;
	}
	public void setTenderPerson(String tenderPerson) {
		this.tenderPerson = tenderPerson;
	}
	public SellTenderBean getSellTenders() {
		return sellTenders;
	}
	public void setSellTenders(SellTenderBean sellTenders) {
		this.sellTenders = sellTenders;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getTm() {
		return tm;
	}
	public void setTm(String tm) {
		this.tm = tm;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getSellProductNo() {
		return sellProductNo;
	}
	public void setSellProductNo(String sellProductNo) {
		this.sellProductNo = sellProductNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getCano() {
		return cano;
	}
	public void setCano(int cano) {
		this.cano = cano;
	}
	public double getLet() {
		return let;
	}
	public void setLet(double let) {
		this.let = let;
	}
	public double getLongs() {
		return longs;
	}
	public void setLongs(double longs) {
		this.longs = longs;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getComplete() {
		return complete;
	}
	public void setComplete(String complete) {
		this.complete = complete;
	}
	@Override
	public String toString() {
		return "SellBoardBean [subject=" + subject + ", content=" + content + ", id=" + id + ", sellProductNo="
				+ sellProductNo + ", productName=" + productName + ", createDate=" + createDate + ", endDate=" + endDate
				+ ", cnt=" + cnt + ", cano=" + cano + ", let=" + let + ", longs=" + longs + ", level=" + level
				+ ", place=" + place + ", price=" + price + ", tm=" + tm + ", img=" + img + ", complete=" + complete
				+ "]";
	}
	
}
