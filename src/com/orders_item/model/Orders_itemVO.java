package com.orders_item.model;
import java.sql.Date;


public class Orders_itemVO implements java.io.Serializable{
	private String orders_no;
	private String product_no;
	private Integer commodities_amonut;
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
	public Integer getCommodities_amonut() {
		return commodities_amonut;
	}
	public void setCommodities_amonut(Integer commodities_amonut) {
		this.commodities_amonut = commodities_amonut;
	}
	public Integer getSelling_price() {
		return selling_price;
	}
	public void setSelling_price(Integer selling_price) {
		this.selling_price = selling_price;
	}
}