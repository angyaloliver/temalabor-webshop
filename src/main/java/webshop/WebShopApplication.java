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

    //addOrders();

  }

  void addOrders(){
    Customer customer = customerRepository.findByContact_Username("asd2");

    OrderDetails order1 = OrderDetails.builder()
            .id(11)
            .customer(customer)
            .shoppingCart(customer.getShoppingCart())
            .delivery(new Delivery())
            .paymentMethod(PaymentMethod.Simple)
            .orderDateTime(LocalDateTime.now())
            .status(OrderStatus.Processing)
            .build();

  OrderDetails order2 = OrderDetails.builder()
          .id(22)
          .customer(customer)
          .shoppingCart(customer.getShoppingCart())
          .delivery(new Delivery())
          .paymentMethod(PaymentMethod.Simple)
          .orderDateTime(LocalDateTime.now())
          .status(OrderStatus.Processing)
          .build();

    orderRepository.save(order1);
    orderRepository.save(order2);

    customer.addOrder(order1);
    customer.addOrder(order2);

    customerRepository.save(customer);
  }
}
