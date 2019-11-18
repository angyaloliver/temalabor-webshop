package webshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webshop.model.*;

import webshop.repository.OrderRepository;
import webshop.repository.ShoppingCartRepository;
import webshop.repository.CustomerRepository;

import java.time.LocalDateTime;

@Service
public class OrderService {

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private CustomerRepository customerRepository;

  public void createOrder(int customerId, int orderId, Delivery delivery, PaymentMethod paymentMethod) {
    Customer customer = customerRepository.getOne(customerId);
    OrderDetails order = OrderDetails.builder()
            .id(orderId)
            .customer(customer)
            .shoppingCart(customer.getShoppingCart())
            .delivery(delivery)
            .paymentMethod(paymentMethod)
            .orderDateTime(LocalDateTime.now())
            .status(OrderStatus.Processing)
            .build();

    customer.addOrder(order);
    customer.setShoppingCart(new ShoppingCart()); //new empty cart to buy new products

    System.out.println(order);
    orderRepository.save(order);

    customerRepository.save(customer);
  }

  public void changeOrderStatus(int orderId, OrderStatus orderStatus) {
    OrderDetails order = orderRepository.getOne(orderId);
    order.setStatus(orderStatus);

    orderRepository.save(order);
  }

}
