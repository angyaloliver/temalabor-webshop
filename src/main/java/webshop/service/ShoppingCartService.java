package webshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webshop.repository.CustomerRepository;
import webshop.repository.ProductRepository;
import webshop.repository.ShoppingCartRepository;

import webshop.model.Product;
import webshop.model.Customer;
import webshop.model.ShoppingCart;

@Service
public class ShoppingCartService {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private ShoppingCartRepository shoppingCartRepository;

  @Autowired
  private CustomerRepository customerRepository;


  public void addProductToCart(int id, int customerId) {

  }

}
