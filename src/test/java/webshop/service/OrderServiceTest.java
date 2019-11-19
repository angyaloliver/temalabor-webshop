package webshop.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import webshop.model.*;
import webshop.repository.CustomerRepository;
import webshop.repository.OrderRepository;
import webshop.repository.ShoppingCartRepository;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

  @InjectMocks
  OrderService orderService;

  @Mock
  OrderRepository orderRepository;

  @Mock
  CustomerRepository customerRepository;

  @Mock
  ShoppingCartRepository shoppingCartRepository;

  @Test
  public void testCreateOrder() {
    Integer shoppingCartId = 333;
    ShoppingCart shoppingCart = new ShoppingCart();
    shoppingCart.setId(shoppingCartId);
    shoppingCartRepository.save(shoppingCart);

    Integer customerId = 666;
    Customer customer = new Customer();
    customer.setId(customerId);
    customer.setShoppingCart(shoppingCart);
    customerRepository.save(customer);

    Delivery delivery = new Delivery();
    PaymentMethod paymentMethod = PaymentMethod.Simple;

    Mockito.when(customerRepository.getOne(customerId)).thenReturn(customer);

    Assert.assertEquals(customer.numberOfOrders(), 0);

    orderService.createOrder(customerId, 1234, delivery, paymentMethod, 778);

    Assert.assertEquals(customer.numberOfOrders(), 1);
  }

  @Test
  public void testChangeOrderStatus() {
    int orderId = 666;
    OrderDetails order= new OrderDetails();
    order.setId(orderId);
    order.setStatus(OrderStatus.Processing);
    orderRepository.save(order);

    OrderStatus newStatus = OrderStatus.Deliverd;

    Mockito.when(orderRepository.getOne(orderId)).thenReturn(order);

    orderService.changeOrderStatus(orderId, newStatus);

    Assert.assertEquals(order.getStatus(), newStatus);
  }
}