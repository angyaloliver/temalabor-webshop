package webshop.service;

import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import webshop.model.Customer;
import webshop.model.Price;
import webshop.model.Product;
import webshop.model.ShoppingCart;
import webshop.repository.CustomerRepository;
import webshop.repository.ProductRepository;
import webshop.repository.ShoppingCartRepository;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartServiceTest {

  @InjectMocks
  ShoppingCartService shoppingCartService;

  @Mock
  ProductRepository productRepository;

  @Mock
  ShoppingCartRepository shoppingCartRepository;

  @Mock
  CustomerRepository customerRepository;

  @Test
  public void testAddOneProductToShoppingCart() {
    Integer productId = 1221;
    Price price = new Price(new BigDecimal("2500"), new BigDecimal("0.27"));
    Product product = new Product(productId, "Sample Product", price);

    Integer shoppingCartId = 3223;
    ShoppingCart shoppingCart = new ShoppingCart();
    shoppingCart.setId(shoppingCartId);

    Integer customerId = 4321;
    Customer customer = new Customer();
    customer.setId(customerId);
    customer.setShoppingCart(shoppingCart);

    Mockito.when(shoppingCartRepository.getOne(shoppingCartId)).thenReturn(shoppingCart);
    Mockito.when(productRepository.getOne(productId)).thenReturn(product);
    Mockito.when(customerRepository.getOne(customerId)).thenReturn(customer);

    shoppingCartService.addProductToCart(productId, customerId);

    Assert.assertEquals(shoppingCart.getProducts().size(), 1);
    Assert.assertEquals(shoppingCart.getProducts().iterator().next().getId(), productId);
  }
}