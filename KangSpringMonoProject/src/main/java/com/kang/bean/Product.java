package com.kang.bean;

public class Product {
	private String id;     
	private int col;      
	private String productName;
	private String createdate;  
	private String enddate;   
	private String imgname;   
	private double let;      
	private int cano;      
	private String groups;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getImgname() {
		return imgname;
	}
	public void setImgname(String imgname) {
		this.imgname = imgname;
	}
	public double getLet() {
		return let;
	}
	public void setLet(double let) {
		this.let = let;
	}
	public int getCano() {
		return cano;
	}
	public void setCano(int cano) {
		this.cano = cano;
	}
	public String getGroups() {
		return groups;
	}
	public void setGroups(String groups) {
		this.groups = groups;
	}
}
