package webshop.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import org.assertj.core.util.Arrays;
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
    Product product = sampleProductWithId(productId);

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

    Assert.assertEquals(1, shoppingCart.getProducts().size());
    Assert.assertEquals(productId, shoppingCart.getProducts().iterator().next().getId());
  }

  @Test
  public void testAddMultipleProductsToShoppingCart() {
    Integer productId1 = 1221;
    Product product1 = sampleProductWithId(productId1);

    Integer productId2 = 3333;
    Product product2 = sampleProductWithId(productId2);

    Integer shoppingCartId = 3223;
    ShoppingCart shoppingCart = new ShoppingCart();
    shoppingCart.setId(shoppingCartId);

    int customerId = 4321;
    Customer customer = new Customer();
    customer.setId(customerId);
    customer.setShoppingCart(shoppingCart);

    Mockito.when(shoppingCartRepository.getOne(shoppingCartId)).thenReturn(shoppingCart);
    Mockito.when(productRepository.getOne(productId1)).thenReturn(product1);
    Mockito.when(productRepository.getOne(productId2)).thenReturn(product2);
    Mockito.when(customerRepository.getOne(customerId)).thenReturn(customer);

    shoppingCartService.addProductToCart(productId1, customerId);
    shoppingCartService.addProductToCart(productId2, customerId);

    Assert.assertEquals(2, shoppingCart.getProducts().size());
    Assert
        .assertArrayEquals(Arrays.array(product1, product2), shoppingCart.getProducts().toArray());
  }

  @Test
  public void testRemoveOneProductFromShoppingCart() {

    Integer productId = 1234;
    Product product = sampleProductWithId(productId);
    Collection<Product> products = new ArrayList<>();
    products.add(product);

    Integer shoppingCartId = 5555;
    ShoppingCart shoppingCart = new ShoppingCart();
    shoppingCart.setProducts(products);

    Integer customerId = 4321;
    Customer customer = new Customer();
    customer.setId(customerId);
    customer.setShoppingCart(shoppingCart);

    Mockito.when(shoppingCartRepository.getOne(shoppingCartId)).thenReturn(shoppingCart);
    Mockito.when(productRepository.getOne(productId)).thenReturn(product);
    Mockito.when(customerRepository.getOne(customerId)).thenReturn(customer);

    shoppingCartService.removeProductFromCart(productId, customerId);

    Assert.assertTrue(shoppingCart.getProducts().isEmpty());
  }

  private Product sampleProductWithId(Integer id) {
    return Product.builder()
        .id(id)
        .name("Sample Product")
        .description("Sample description")
        .originalPrice(new Price(new BigDecimal("2500"), new BigDecimal("0.27")))
        .build();
  }
}