package webshop.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webshop.model.Customer;
import webshop.model.CustomerContact;
import webshop.model.OrderDetails;
import webshop.repository.CustomerRepository;

@Service
public class CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  public void createCustomer(CustomerContact cc) {
    customerRepository.save(new Customer(cc));
  }

  public void deleteCustomer(int customerId) {
    customerRepository.deleteById(customerId);
  }

  public Customer getCustomerById(Integer id) {
    return customerRepository.getOne(id);
  }

  public List<Customer> getAllCustomers() {
    return customerRepository.findAll();
  }

  public void changeContact(int customerId, CustomerContact customerContact) {

  }

  public void addOrder(OrderDetails orderDetails, int customerId) {

  }

  void addOrder(OrderDetails orderDetails, int customerId) {

  }
}
