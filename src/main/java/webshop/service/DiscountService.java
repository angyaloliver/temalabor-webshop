package webshop.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import webshop.model.Product;
import webshop.model.ProductCategory;
import webshop.repository.ProductCategoryRepository;
import webshop.repository.ProductRepository;

@Service
public class DiscountService {

  @Autowired
  ProductRepository productRepository;

  @Autowired
  ProductCategoryRepository productCategoryRepository;

  @Transactional
  public void discountProductsInCategory(String categoryName, BigDecimal discountRate) {

    List<ProductCategory> productCategories = productCategoryRepository.findByName(categoryName);

    for (ProductCategory productCategory : productCategories) {
      for (Product product : productCategory.getProducts()) {
        product.discount(discountRate);
      }
    }
  }


}