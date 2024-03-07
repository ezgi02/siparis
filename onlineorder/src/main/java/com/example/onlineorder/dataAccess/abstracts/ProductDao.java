package com.example.onlineorder.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.onlineorder.entities.concretes.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{
	 Product getByProductName(String productName);
	 
	 Product getByProductNameAndCategory_CategoryId(String productName,int categoryId);
	 
	 List<Product> getByProductNameOrCategory(String productName, int categoryId);

	 List<Product> getByCategoryIn(List<Integer> categories);

	 List<Product> getByProductNameContains(String productName);

	 List<Product> getByProductNameStartsWith(String productName);
	 
	 @Query("From Product where productName=:productName and categoryId=:categoryId")
	 List<Product> getByNameOrCategory(String productName, int categoryId);
	
}
