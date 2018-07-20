package com.kang.bean;

public class BuyTenderBean {
	private int productNo; // 상품번호
    private int tenderPrice;  //상품입찰 가격
    private String id; // 아이디
    private String memo; //메모
    private int buyTenderNo;
    private String tel;
    private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public int getTenderPrice() {
		return tenderPrice;
	}
	public void setTenderPrice(int tenderPrice) {
		this.tenderPrice = tenderPrice;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public int getBuyTenderNo() {
		return buyTenderNo;
	}
	public void setBuyTenderNo(int buyTenderNo) {
		this.buyTenderNo = buyTenderNo;
	}
	@Override
	public String toString() {
		return "BuyTenderBean [productNo=" + productNo + ", tenderPrice=" + tenderPrice + ", id=" + id + ", memo="
				+ memo + ", buyTenderNo=" + buyTenderNo + "]";
	}
}
