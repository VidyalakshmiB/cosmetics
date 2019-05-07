package com.niit.CosmeticsBackend.Model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Supplier {
	@Id
	private String supId;
	private String supName;
    private String supE_mail;
    private String phone_no;
    private String sup_Address;
    
    
    public Supplier()
	{
		this.supId="SUP"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
    
   @OneToMany(mappedBy="supplier")
   private List<Product> product;
	
    public String getSupId() {
		return supId;
	}
	public void setSupId(String supId) {
		this.supId = supId;
	}
	public String getSupName() {
		return supName;
	}
	public void setSupName(String supName) {
		this.supName = supName;
	}
	public String getSupE_mail() {
		return supE_mail;
	}
	public void setSupE_mail(String supE_mail) {
		this.supE_mail = supE_mail;
	}
	public String getSup_Address() {
		return sup_Address;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public void setSup_Address(String sup_Address) {
		this.sup_Address = sup_Address;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
  
    
    }

