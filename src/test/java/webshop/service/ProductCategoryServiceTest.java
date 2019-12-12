package webshop.service;

import java.math.BigDecimal;
import org.junit.Assert;
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
public class ProductCategoryServiceTest {

  @Autowired
  ProductCategoryService productCategoryService;

  @Autowired
  ProductRepository productRepository;

  @Autowired
  ProductCategoryRepository productCategoryRepository;

  @Test
  public void testAddOneCategoryWithOneProduct() {

    Product product1 = Product.builder()
        .id(1)
        .name("Product 1")
        .originalPrice(new Price(BigDecimal.valueOf(100.0), BigDecimal.valueOf(0.27)))
        .build();

    ProductCategory productCategory = ProductCategory.builder()
        .name("catName")
        .build();

    product1.addProductCategory(productCategory);
    productCategory.addProduct(product1);

    productCategoryRepository.save(productCategory);

    product1 = productRepository.save(product1);

    Product returnedProduct = productRepository.getOne(1);
    System.out.println(returnedProduct.getName());

    //ProductCategory returnedProductCategory = productCategoryRepository.getOne(23);

    Assert.assertTrue(returnedProduct.getProductCategories().contains(productCategory));
  }

}
