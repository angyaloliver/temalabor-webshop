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

  public void createOrder(int customerId, Delivery delivery, PaymentMethod paymentMethod) {
    Customer customer = customerRepository.getOne(customerId);
    OrderDetails order = new OrderDetails(customer.getShoppingCart(), customer, delivery, paymentMethod);

    customer.addOrder(order);
    customer.deleteShoppingCart();

    orderRepository.save(order);
    customerRepository.save(customer);
  }

  public void changeOrderStatus(int orderId, OrderStatus orderStatus) {
    OrderDetails order = orderRepository.getOne(orderId);
    order.setStatus(orderStatus);

    orderRepository.save(order);
  }

}
