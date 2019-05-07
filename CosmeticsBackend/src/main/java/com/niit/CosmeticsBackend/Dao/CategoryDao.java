package com.niit.CosmeticsBackend.Dao;

import java.util.List;

import com.niit.CosmeticsBackend.Model.Category;

public interface CategoryDao {
public boolean saveorupdate(Category Category);
public boolean delete(Category Category);
public Category getCategory(String catId);
public List<Category> list();
}
