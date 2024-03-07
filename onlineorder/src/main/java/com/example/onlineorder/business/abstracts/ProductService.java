package com.example.onlineorder.business.abstracts;

import java.util.List;

//import org.springframework.data.jpa.repository.Query;

import com.example.onlineorder.core.utilities.results.DataResult;
import com.example.onlineorder.core.utilities.results.Result;
import com.example.onlineorder.entities.concretes.Product;

//The interface provides an Apı for product operations
public interface ProductService {
	
	 DataResult<List<Product>> getAll();
	 Result add(Product product);
	 
	 DataResult<Product> getByProductName(String productName);
	 
	 DataResult<Product> getByProductNameAndCategory_CategoryId(String productName,int categoryId);
	 
	 DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId);

	 DataResult<List<Product>> getByCategoryIn(List<Integer> categories);

	 DataResult<List<Product>> getByProductNameContains(String productName);

	 DataResult<List<Product>> getByProductNameStartsWith(String productName);
	 
	 DataResult<List<Product>> getByNameOrCategory(String productName, int categoryId);
}
