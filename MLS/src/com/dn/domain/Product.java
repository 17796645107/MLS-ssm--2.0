package com.dn.domain;

import java.io.Serializable;

//商品实体类
public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;//id
	private Integer seller_id;//商家ID
	private Integer mid;//商品分类
	private String title;//商品名称
	private String color;//商品颜色
	private String size;//商品尺寸
	private Double price;//商品价格
	private Integer num;//商品库存
	private String image;//图片
	private Integer collect;//收藏
	private Integer status;//状态
	private Page page;//分页
	
	public Product() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public Integer getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(Integer seller_id) {
		this.seller_id = seller_id;
	}

	public Integer getMid() {
		return mid;
	}
	
	

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getPrice() {
		return price;
	}


	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getCollect() {
		return collect;
	}

	public void setCollect(Integer collect) {
		this.collect = collect;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	

}
