package webshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webshop.model.Product;
import webshop.model.ShoppingCart;
import webshop.repository.CustomerRepository;
import webshop.repository.ProductRepository;
import webshop.repository.ShoppingCartRepository;

@Service
public class ShoppingCartService {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private ShoppingCartRepository shoppingCartRepository;

  @Autowired
  private CustomerRepository customerRepository;


  public void addProductToCart(int productId, int customerId) {
    ShoppingCart shoppingCart = customerRepository.getOne(customerId).getShoppingCart();
    Product product = productRepository.getOne(productId);

    shoppingCart.addProduct(product);
  }

}
