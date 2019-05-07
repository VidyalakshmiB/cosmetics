package com.niit.CosmeticsBackend.Dao;
 
import java.util.List;

import com.niit.CosmeticsBackend.Model.Product;


public interface ProductDao {
	public boolean saveorupdate(Product Product);
	public boolean delete(Product Product);
	public Product getProduct(String prodId);
	public List<Product> list();

}
