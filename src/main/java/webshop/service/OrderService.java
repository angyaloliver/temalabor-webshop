package webshop.service;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webshop.model.Customer;
import webshop.model.Delivery;
import webshop.model.OrderDetails;
import webshop.model.OrderStatus;
import webshop.model.PaymentMethod;
import webshop.model.ShoppingCart;
import webshop.repository.CustomerRepository;
import webshop.repository.OrderRepository;
import webshop.repository.ShoppingCartRepository;

@Service
public class OrderService {

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private ShoppingCartRepository shoppingCartRepository;

  public void createOrder(int customerId, int orderId, Delivery delivery,
      PaymentMethod paymentMethod, int shoppingCartIdNew) {
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

    ShoppingCart shoppingCartNew = new ShoppingCart();
    shoppingCartNew.setId(shoppingCartIdNew);
    shoppingCartRepository.save(shoppingCartNew);

    customer.addOrder(order);
    customer.setShoppingCart(shoppingCartNew); //new empty cart to buy new products

    orderRepository.save(order);
    customerRepository.save(customer);
  }

  public void changeOrderStatus(int orderId, OrderStatus orderStatus) {
    OrderDetails order = orderRepository.getOne(orderId);
    order.setStatus(orderStatus);

    orderRepository.save(order);
  }

}
