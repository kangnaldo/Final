package com.kang.bean;

public class SellTenderBean {
	private int sellProductNo; // 판매상품번호
    private int tenderPrice;  //상품입찰 가격
    private String id; // 아이디
	private String memo; //메모
    private int sellTenderNo; //판매 입찰 번호
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
	public int getSellProductNo() {
		return sellProductNo;
	}
	public void setSellProductNo(int sellProductNo) {
		this.sellProductNo = sellProductNo;
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
	public int getSellTenderNo() {
		return sellTenderNo;
	}
	public void setSellTenderNo(int sellTenderNo) {
		this.sellTenderNo = sellTenderNo;
	}
	@Override
	public String toString() {
		return "SellTenderBean [sellProductNo=" + sellProductNo + ", tenderPrice=" + tenderPrice + ", id=" + id
				+ ", memo=" + memo + ", sellTenderNo=" + sellTenderNo + "]";
	}

}
