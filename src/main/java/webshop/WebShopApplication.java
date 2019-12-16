package webshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import webshop.model.*;
import webshop.repository.CustomerRepository;
import webshop.repository.OrderRepository;
import webshop.repository.RoleRepository;
import webshop.service.CustomerService;
import webshop.service.OrderService;

import java.time.LocalDateTime;

@SpringBootApplication
public class WebShopApplication implements CommandLineRunner {

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  CustomerRepository customerRepository;

  @Autowired
  OrderRepository orderRepository;

  public static void main(String[] args) {
    SpringApplication.run(WebShopApplication.class, args);
  }

  @Override
  public void run(String... args) {
    if (roleRepository.findByName("ROLE_USER") == null) {
      roleRepository.save(new Role("ROLE_USER"));
    }
    if (roleRepository.findByName("ROLE_ADMIN") == null) {
      roleRepository.save(new Role("ROLE_ADMIN"));
    }
  }
}
