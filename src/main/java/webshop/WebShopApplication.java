package webshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import webshop.repository.CustomerRepository;
import webshop.repository.OrderRepository;
import webshop.repository.ProductCategoryRepository;
import webshop.repository.ProductRepository;
import webshop.repository.RoleRepository;
import webshop.repository.ShoppingCartRepository;

@SpringBootApplication
public class WebShopApplication implements CommandLineRunner {

  @Autowired
  ProductCategoryRepository productCategoryRepository;
  @Autowired
  CustomerRepository customerRepository;
  @Autowired
  ProductRepository productRepository;
  @Autowired
  OrderRepository orderRepository;
  @Autowired
  ShoppingCartRepository shoppingCartRepository;
  @Autowired
  RoleRepository roleRepository;

  public static void main(String[] args) {
    SpringApplication.run(WebShopApplication.class, args);
  }

  @Override
  public void run(String... args) {
  }

}
