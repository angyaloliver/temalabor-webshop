package webshop.service;

import webshop.repository.CustomerRepository;
import webshop.repository.ProductRepository;
import webshop.repository.ShoppingCartRepository;

import webshop.model.Product;
import webshop.model.Customer;
import webshop.model.ShoppingCart;

public class ShoppingCartService {

  private ProductRepository productRepository;
  private ShoppingCartRepository shoppingCartRepository;
  private CustomerRepository customerRepository;


  public void addProductToCart(int id, int customerId) {
    Product p = productRepository.findbyId(id);
    Customer u = customerRepository.findbyId(customerId);
    ShoppingCart sc = u.getShoppingCart();

    sc.addProduct(p);

    shoppingCartRepository.save(sc);
    customerRepository.save(u);
  }

}
