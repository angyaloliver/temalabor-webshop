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
public class OrderServiceIT {

  @InjectMocks
  OrderService orderService;

  @Mock
  OrderRepository orderRepository;

  @Mock
  CustomerRepository customerRepository;

  @Test
  public void testCreateOrder() {
    Integer productId = 111;
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

    Assert.assertEquals(product, customer.getShoppingCart().getProducts().iterator().next());

    orderService.createOrder(customerId, 1234, delivery, paymentMethod);

    ShoppingCart orderShoppingCart = customer.getOrderDetails().iterator().next().getShoppingCart();

    Assert.assertEquals(shoppingCart, orderShoppingCart);
    Assert.assertEquals(false, orderShoppingCart.getProducts().isEmpty());
    Assert.assertTrue(customer.getShoppingCart().getProducts().isEmpty());


  }
}