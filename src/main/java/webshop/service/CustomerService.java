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

  public Customer getCustomerByEmail(String email) {
    return customerRepository.findByContact_EmailAddress(email);
  }

  public void changeContact(int customerId, CustomerContact customerContact) {
    Customer customer = customerRepository.getOne(customerId);
    customer.setContact(customerContact);

    customerRepository.save(customer);
  }

  public void addOrder(OrderDetails orderDetails, int customerId) {

  }

}
