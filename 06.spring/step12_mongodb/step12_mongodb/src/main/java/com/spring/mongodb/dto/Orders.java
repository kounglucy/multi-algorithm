package com.spring.mongodb.dto;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orders")
public class Orders {
	
	@Id
	private ObjectId _id;
	private Double order_id;
	private String order_user;
	private Double product_id;
	
	public Orders(ObjectId _id, Double order_id, String order_user, Double product_id) {
		super();
		this._id = _id;
		this.order_id = order_id;
		this.order_user = order_user;
		this.product_id = product_id;
	}
	
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public Double getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Double order_id) {
		this.order_id = order_id;
	}
	public String getOrder_user() {
		return order_user;
	}
	public void setOrder_user(String order_user) {
		this.order_user = order_user;
	}
	public Double getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Double product_id) {
		this.product_id = product_id;
	}
	
	@Override
	public String toString() {
		return "Orders [_id=" + _id + ", order_id=" + order_id + ", order_user=" + order_user + ", product_id="
				+ product_id + "]";
	}
}