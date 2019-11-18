package webshop.service;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import webshop.model.Price;
import webshop.model.Product;
import webshop.model.ProductCategory;
import webshop.repository.ProductCategoryRepository;
import webshop.repository.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@AutoConfigureTestDatabase
public class DiscountServiceIT {

  @Autowired
  DiscountService discountService;

  @Autowired
  ProductCategoryRepository productCategoryRepository;

  @Autowired
  ProductRepository productRepository;

  @Test
  public void testDiscountProductsInCategory() {

    Product product1 = new Product(1, "Product 1",
        new Price(BigDecimal.valueOf(100.0), BigDecimal.valueOf(0.27)));
    Product product2 = new Product(2, "Product2",
        new Price(BigDecimal.valueOf(200.0), BigDecimal.valueOf(0.19)));
    product1 = productRepository.save(product1);
    product2 = productRepository.save(product2);

    ProductCategory productCategory = new ProductCategory("ABC");
    productCategory.addProduct(product1);
    productCategory.addProduct(product2);
    productCategoryRepository.save(productCategory);

    BigDecimal delta = BigDecimal.valueOf(0.0001);
    assertThat(product1.getOriginalPrice().getGross(), closeTo(BigDecimal.valueOf(127.0), delta));
    assertThat(product2.getOriginalPrice().getNet(), closeTo(BigDecimal.valueOf(200.0), delta));

    discountService.discountProductsInCategory("ABC", BigDecimal.valueOf(0.8));

    assertThat(product1.getOriginalPrice().getGross(), closeTo(BigDecimal.valueOf(101.6), delta));
    assertThat(product2.getOriginalPrice().getNet(), closeTo(BigDecimal.valueOf(160.0), delta));
  }

}