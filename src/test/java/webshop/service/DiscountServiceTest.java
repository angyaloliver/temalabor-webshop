package webshop.service;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import webshop.model.Price;
import webshop.model.Product;
import webshop.model.ProductCategory;
import webshop.repository.ProductCategoryRepository;
import webshop.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.class)
public class DiscountServiceTest {

  @InjectMocks
  DiscountService discountService;

  @Mock
  ProductCategoryRepository categoryRepository;

  @Mock
  ProductRepository productRepository;

  @Test
  public void testDiscountProductsInCategory() throws Exception {

    ProductCategory productCategory = new ProductCategory("ABC");
    Product product1 = new Product(1, "Product 1",
        new Price(BigDecimal.valueOf(100.0), BigDecimal.valueOf(0.27)));
    Product product2 = new Product(2, "Product2",
        new Price(BigDecimal.valueOf(200.0), BigDecimal.valueOf(0.19)));
    productCategory.addProduct(product1);
    productCategory.addProduct(product2);

    when(categoryRepository.findByName("ABC")).thenReturn(Arrays.asList(productCategory));

    BigDecimal delta = BigDecimal.valueOf(0.0001);
    assertThat(product1.getOriginalPrice().getGross(), closeTo(BigDecimal.valueOf(127.0), delta));
    assertThat(product2.getOriginalPrice().getNet(), closeTo(BigDecimal.valueOf(200.0), delta));

    discountService.discountProductsInCategory("ABC", BigDecimal.valueOf(0.8));

    assertThat(product1.getOriginalPrice().getGross(), closeTo(BigDecimal.valueOf(101.6), delta));
    assertThat(product2.getOriginalPrice().getNet(), closeTo(BigDecimal.valueOf(160.0), delta));
  }
}