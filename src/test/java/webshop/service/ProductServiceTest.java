package webshop.service;

import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import webshop.model.Price;
import webshop.model.Product;
import webshop.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

  @InjectMocks
  ProductService productService;

  @Mock
  ProductRepository productRepository;

  @Test
  public void testChangeNumberInStock() {
    Integer productId = 9999;
    int initialQuantity = 50;

    Product product = Product.builder()
        .id(productId)
        .name("Sample Product")
        .description("Sample description")
        .originalPrice(new Price(new BigDecimal("2500"), new BigDecimal("0.27")))
        .numberInStock(initialQuantity)
        .build();

    Mockito.when(productRepository.getOne(productId)).thenReturn(product);

    int newQuantity = 100;
    productService.changeNumberInStock(productId, newQuantity);

    Assert.assertEquals(newQuantity, productService.getProductById(productId).getNumberInStock());
  }
}