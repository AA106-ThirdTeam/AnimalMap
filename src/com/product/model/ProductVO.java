package com.product.model;
import java.sql.Date;

public class ProductVO implements java.io.Serializable{
	private String product_no;
	private String product_name;
	private String product_introduction;
	private Integer product_price;
	private Integer product_stock;
	private String product_picture_large;
	private String product_picture_small;
	private Integer product_status;
	private Date product_create_date;
	private String product_info;
	private String product_kind_no;
	
	
	public String getProduct_no() {
		return product_no;
	}
	public void setProduct_no(String product_no) {
		this.product_no = product_no;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_introduction() {
		return product_introduction;
	}
	public void setProduct_introduction(String product_introduction) {
		this.product_introduction = product_introduction;
	}
	public Integer getProduct_price() {
		return product_price;
	}
	public void setProduct_price(Integer product_price) {
		this.product_price = product_price;
	}
	public Integer getProduct_stock() {
		return product_stock;
	}
	public void setProduct_stock(Integer product_stock) {
		this.product_stock = product_stock;
	}
	public String getProduct_picture_large() {
		return product_picture_large;
	}
	public void setProduct_picture_large(String product_picture_large) {
		this.product_picture_large = product_picture_large;
	}
	public String getProduct_picture_small() {
		return product_picture_small;
	}
	public void setProduct_picture_small(String product_picture_small) {
		this.product_picture_small = product_picture_small;
	}
	public Integer getProduct_status() {
		return product_status;
	}
	public void setProduct_status(Integer product_status) {
		this.product_status = product_status;
	}
	public Date getProduct_create_date() {
		return product_create_date;
	}
	public void setProduct_create_date(Date product_create_date) {
		this.product_create_date = product_create_date;
	}
	public String getProduct_info() {
		return product_info;
	}
	public void setProduct_info(String product_info) {
		this.product_info = product_info;
	}
	public String getProduct_kind_no() {
		return product_kind_no;
	}
	public void setProduct_kind_no(String product_kind_no) {
		this.product_kind_no = product_kind_no;
	}
	
	
	
}
