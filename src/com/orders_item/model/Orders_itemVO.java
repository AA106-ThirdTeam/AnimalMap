package com.orders_item.model;
import java.sql.Date;


public class Orders_itemVO implements java.io.Serializable{
	private String orders_no;
	private String product_no;
	private Integer commodities_amount;
	private Integer selling_price;
	public String getOrders_no() {
		return orders_no;
	}
	public void setOrders_no(String orders_no) {
		this.orders_no = orders_no;
	}
	public String getProduct_no() {
		return product_no;
	}
	public void setProduct_no(String product_no) {
		this.product_no = product_no;
	}
	public Integer getCommodities_amount() {
		return commodities_amount;
	}
	public void setCommodities_amount(Integer commodities_amount) {
		this.commodities_amount = commodities_amount;
	}
	public Integer getSelling_price() {
		return selling_price;
	}
	public void setSelling_price(Integer selling_price) {
		this.selling_price = selling_price;
	}
}