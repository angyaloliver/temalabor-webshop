package webshop.service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
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
  public void testModifyProduct() {
    Integer productToBeModifiedId = 9999;

    Product productToBeModified = Product.builder()
        .id(productToBeModifiedId)
        .name("ProductToBeModified")
        .description("This product has to be modified.")
        .originalPrice(new Price(new BigDecimal("2500"), new BigDecimal("0.27")))
        .build();

    Integer modifyingProductId = 1111;
    String modifiedName = "ModifiedProduct";
    String modifiedDescription = "This product has been modified.";
    int numberInStock = 5;

    Product modifyingProduct = Product.builder()
        .id(modifyingProductId)
        .name(modifiedName)
        .description(modifiedDescription)
        .productCategories(new HashSet<>())
        .images(new HashSet<>())
        .numberInStock(numberInStock)
        .build();

    Mockito.when(productRepository.getOne(productToBeModifiedId)).thenReturn(productToBeModified);

    productService.modifyProduct(productToBeModifiedId, modifyingProduct);

    Assert.assertEquals("ModifiedProduct",
        productService.getProductById(productToBeModifiedId).getName());
    Assert.assertEquals("This product has been modified.",
        productService.getProductById(9999).getDescription());
    Assert.assertEquals(5, productService.getProductById(productToBeModifiedId).getNumberInStock());
    Assert.assertNull(productService.getProductById(productToBeModifiedId).getOriginalPrice());
    Assert.assertEquals(Collections.EMPTY_SET,
        productService.getProductById(productToBeModifiedId).getProductCategories());
    Assert.assertEquals(Collections.EMPTY_SET,
        productService.getProductById(productToBeModifiedId).getImages());
    Assert.assertNull(productService.getProductById(productToBeModifiedId).getDiscountRate());
  }

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