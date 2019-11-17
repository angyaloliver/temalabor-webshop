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

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

  @InjectMocks
  OrderService orderService;

  @Mock
  OrderRepository orderRepository;

  @Mock
  CustomerRepository customerRepository;

  @Test
  public void testCreateOrder() {
    Integer productId = 1221;
    Product product = new Product();
    product.setId(productId);

    Integer shoppingCartId = 333;
    ShoppingCart shoppingCart = new ShoppingCart();
    shoppingCart.setId(shoppingCartId);
    shoppingCart.addProduct(product);

    Integer customerId = 666;
    Customer customer = new Customer();
    customer.setId(customerId);
    customer.setShoppingCart(shoppingCart);

    Delivery delivery = new Delivery();
    PaymentMethod paymentMethod = PaymentMethod.Simple;

    Mockito.when(customerRepository.getOne(customerId)).thenReturn(customer);

    orderService.createOrder(customerId, delivery, paymentMethod);

    Assert.assertEquals(customer.numberOfOrders(), 1);
  }

  @Test
  public void testChangeOrderStatus() {
    int orderId = 666;
    OrderDetails order= new OrderDetails();
    order.setId(orderId);
    order.setStatus(OrderStatus.Processing);

    OrderStatus newStatus = OrderStatus.Deliverd;

    Mockito.when(orderRepository.getOne(orderId)).thenReturn(order);

    orderService.changeOrderStatus(orderId, newStatus);

    Assert.assertEquals(order.getStatus(), newStatus);
  }
}