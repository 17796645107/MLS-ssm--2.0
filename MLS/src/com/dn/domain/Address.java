package com.dn.domain;
//用户地址实体类
public class Address {

	private Integer id;//ID
	private Integer user_id;//用户ID
	private String address;//详细地址
	private String name;//真实姓名
	private String province;//省份
	private String city;//城市
	private String Area;//地区
	private String postcode;//邮政编码
	private Long telephone;//手机号码
	private Integer status;
	public Address() {
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getUser_id() {
		return user_id;
	}


	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}


	public String getArea() {
		return Area;
	}


	public void setArea(String area) {
		Area = area;
	}


	public String getAddress() {
		return address;
	}

	
	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getProvince() {
		return province;
	}


	public void setProvince(String province) {
		this.province = province;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getPostcode() {
		return postcode;
	}


	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}


	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}


	public Long getTelephone() {
		return telephone;
	}
	
}
