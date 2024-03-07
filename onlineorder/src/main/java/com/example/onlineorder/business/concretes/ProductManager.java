package com.example.onlineorder.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlineorder.business.abstracts.ProductService;
import com.example.onlineorder.core.utilities.results.DataResult;
import com.example.onlineorder.core.utilities.results.Result;
import com.example.onlineorder.core.utilities.results.SuccessDataResult;
import com.example.onlineorder.core.utilities.results.SuccessResult;
import com.example.onlineorder.dataAccess.abstracts.ProductDao;
import com.example.onlineorder.entities.concretes.Product;
//This class instanties the business logic and executes the actual
//product operantions
@Service
public class ProductManager implements ProductService{
	private ProductDao productDao;
	
	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}
	@Override
	public DataResult<List<Product>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Product>>
		(this.productDao.findAll(),"Data Listelendi");
				
	}
	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("Ürün Eklendi");
	}
	
	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SuccessDataResult<Product>
		(this.productDao.getByProductName(productName),"Data Listelendi");
	}
	
	@Override
	public DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId) {
		///buiness codes
		return new SuccessDataResult<Product>
		(this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"Data Listelendi");
	}
	
	@Override
	public DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameOrCategory(productName, categoryId),"Data Listelendi");
	}
	
	@Override
	public DataResult<List<Product>> getByCategoryIn(List<Integer> categories) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByCategoryIn(categories),"Data Listelendi");
	}
	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameContains(productName),"Data Listelendi");	
	}
	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameStartsWith(productName),"Data Listelendi");
	}
	@Override
	public DataResult<List<Product>> getByNameOrCategory(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByNameOrCategory(productName, categoryId),"Data Listelendi");
	}
	

}
