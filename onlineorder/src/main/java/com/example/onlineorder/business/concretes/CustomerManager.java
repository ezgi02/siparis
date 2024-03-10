package com.example.onlineorder.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlineorder.business.abstracts.CustomerService;
import com.example.onlineorder.core.utilities.results.DataResult;
import com.example.onlineorder.core.utilities.results.ErrorDataResult;
import com.example.onlineorder.core.utilities.results.ErrorResult;
import com.example.onlineorder.core.utilities.results.Result;
import com.example.onlineorder.core.utilities.results.SuccessDataResult;
import com.example.onlineorder.core.utilities.results.SuccessResult;
import com.example.onlineorder.dataAccess.abstracts.CustomerDao;
import com.example.onlineorder.entities.concretes.Customer;

@Service
public class CustomerManager implements CustomerService{
	  private final CustomerDao customerDao;
	  
	  @Autowired
	  public CustomerManager(CustomerDao customerDao) {
		  this.customerDao=customerDao;
	  }

    
  @Override
  public DataResult<List<Customer>> getAllCustomers() {
      return new SuccessDataResult<>(customerDao.findAll(), "Customers listed successfully");
  }

  @Override
  public DataResult<Customer> getCustomerById(int id) {
      Customer customer = customerDao.findById(id).orElse(null);
      if (customer == null) {
          return new ErrorDataResult<>("Customer not found");
      }
      return new SuccessDataResult<>(customer, "Customer found successfully");
  }

  @Override
  public Result addCustomer(Customer customer) {
     /* if (customer.getId() != 0) {
          return new ErrorResult("Customer id should be empty for adding a new customer");
      }*/
      customerDao.save(customer);
      return new SuccessResult("Customer added successfully");
  }

  @Override
  public Result updateCustomer(Customer customer) {
      if (customer.getId() == 0) {
          return new ErrorResult("Customer id cannot be empty for updating customer");
      }
      customerDao.save(customer);
      return new SuccessResult("Customer updated successfully");
  }

  @Override
  public Result deleteCustomer(int id) {
      Customer customer = customerDao.findById(id).orElse(null);
      if (customer == null) {
          return new ErrorResult("Customer not found");
      }
      customerDao.delete(customer);
      return new SuccessResult("Customer deleted successfully");
  }
}



