package webshop.service;

import webshop.model.*;

import webshop.repository.OrderRepository;
import webshop.repository.ShoppingCartRepository;
import webshop.repository.CustomerRepository;

public class OrderService {

  private OrderRepository orderRepository;
  private ShoppingCartRepository shoppingCartRepository;
  private CustomerRepository customerResponsitory;

  public void addOrder(int customerId, Delivery delivery, PaymentMethod paymentMethod) {
    Customer c = customerResponsitory.findbyId(customerId);
    Order o = Order.createNewOrder(c.getShoppingCart(), c, delivery, paymentMethod);

    c.deleteShoppingCart();

    orderRepository.save(o);
    customerResponsitory.save(c);
  }

  public void changeStatus(int id, OrderStatus orderStatus) {
    Order o = orderRepository.findbyId(id);
    o.setStatus(orderStatus);
    orderRepository.save(o);
  }

}
