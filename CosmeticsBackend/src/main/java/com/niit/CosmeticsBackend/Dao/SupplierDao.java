package com.niit.CosmeticsBackend.Dao;

import java.util.List;

import com.niit.CosmeticsBackend.Model.Supplier;


public interface SupplierDao {
public boolean saveorupdate(Supplier Supplier);
public boolean delete(Supplier Supplier);
public Supplier getSupplier(String supId);
public List<Supplier> list();
}
