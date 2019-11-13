package webshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webshop.model.*;

import webshop.repository.OrderRepository;
import webshop.repository.ShoppingCartRepository;
import webshop.repository.CustomerRepository;

@Service
public class OrderService {

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private ShoppingCartRepository shoppingCartRepository;

  @Autowired
  private CustomerRepository customerRepository;

  public void addOrder(int customerId, Delivery delivery, PaymentMethod paymentMethod) {

  }

  public void changeStatus(int id, OrderStatus orderStatus) {

  }

}
