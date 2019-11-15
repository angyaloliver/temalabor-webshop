package webshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webshop.model.CustomerContact;
import webshop.model.OrderDetails;

import webshop.repository.CustomerRepository;

@Service
public class CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  void addCustomer(CustomerContact cc) {

  }

  void deleteCustomer(int customerId) {

  }

  void changeContact(int customerId, CustomerContact customerContact) {

  }

  void addOrder(OrderDetails orderDetails, int customerId) {

  }
}
