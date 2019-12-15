package webshop.service;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import webshop.model.Customer;
import webshop.model.CustomerContact;
import webshop.model.OrderDetails;
import webshop.repository.CustomerRepository;
import webshop.repository.RoleRepository;

@Service("userDetailsService")
public class CustomerService implements UserDetailsService {

  BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
  @Autowired
  private CustomerRepository customerRepository;
  @Autowired
  private Assembler assembler;
  @Autowired
  private RoleRepository roleRepository;


  public void createCustomer(CustomerContact cc) {
    cc.setPassword(this.bCryptPasswordEncoder.encode(cc.getPassword()));
    cc.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));
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

  public void addOrder(int customerId, OrderDetails orderDetails) {
    Customer customer = customerRepository.getOne(customerId);
    customer.addOrder(orderDetails);

    customerRepository.save(customer);
  }

  public UserDetails loadUserByUsername(String username)
      throws UsernameNotFoundException {
    Customer customer = customerRepository.findByContact_Username(username);
    if (customer == null) {
      throw new UsernameNotFoundException("User not found.");
    }
    return assembler.buildUserFromCustomer(customer);
  }
}
