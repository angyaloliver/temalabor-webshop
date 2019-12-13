package webshop.service;

import java.math.BigDecimal;
import java.util.List;
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

  @Test
  public void testGetAllProductsOfCategory() {

    Product product1 = Product.builder()
        .name("Product 1")
        .originalPrice(new Price(BigDecimal.valueOf(100.0), BigDecimal.valueOf(0.27)))
        .build();

    Product product2 = Product.builder()
        .name("Product 2")
        .originalPrice(new Price(BigDecimal.valueOf(100.0), BigDecimal.valueOf(0.27)))
        .build();

    Product product3 = Product.builder()
        .name("Product 3")
        .originalPrice(new Price(BigDecimal.valueOf(100.0), BigDecimal.valueOf(0.27)))
        .build();

    String categoryName = "catName";

    ProductCategory productCategory = ProductCategory.builder()
        .name(categoryName)
        .build();

    ProductCategory productCategory2 = ProductCategory.builder()
        .name("another category")
        .build();

    product1.addProductCategory(productCategory);
    product2.addProductCategory(productCategory);

    product3.addProductCategory(productCategory2);

    productCategory.addProduct(product1);
    productCategory.addProduct(product2);
    productCategory2.addProduct(product3);

    productCategoryRepository.save(productCategory);
    productCategoryRepository.save(productCategory2);

    productRepository.save(product1);
    productRepository.save(product2);
    productRepository.save(product3);

    Product returnedProduct = productRepository.getOne(1);
    System.out.println(returnedProduct.getName());

    List<Product> productsReturned = productCategoryService
        .getAllProductsOfCategory(categoryName);

    Assert.assertTrue(productsReturned.size() == 2);

    Assert.assertTrue(productsReturned.contains(product1));
    Assert.assertTrue(productsReturned.contains(product2));
    Assert.assertFalse(productsReturned.contains(product3));

  }

}
