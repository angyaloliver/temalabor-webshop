package webshop.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webshop.model.Customer;
import webshop.model.CustomerContact;
import webshop.model.ShoppingCart;
import webshop.service.CustomerService;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@AllArgsConstructor
@RestController
@RequestMapping("customers")
public class CustomerController {

  CustomerService customerService;

  @PostMapping("register")
  public void createCustomer(
      @RequestBody CustomerContact customerContact) {
    customerService.createCustomer(customerContact);
  }

  @DeleteMapping("{id}")
  public void deleteCustomer(
      @PathVariable("id") Integer id) {
    customerService.deleteCustomer(id);
  }

  @GetMapping("{id}")
  public Customer getCustomerById(
      @PathVariable Integer id) {
    return customerService.getCustomerById(id);
  }

    @GetMapping("get_id/{username}")
    public int getIdByUsername(@PathVariable String username) {
        return customerService.getCustomerByUsername(username).getId();
    }

  @GetMapping("email/{email}")
  public Customer getCustomerByEmail(
      @PathVariable String email) {
    return customerService.getCustomerByEmail(email);
  }

  @GetMapping("shopping_cart/{id}")
  public ShoppingCart getShoppingCart(
      @PathVariable Integer id) {
    return customerService.getCustomerById(id).getShoppingCart();
  }

  @GetMapping
  public List<Customer> getAllCustomers() {
    return customerService.getAllCustomers();
  }

}
