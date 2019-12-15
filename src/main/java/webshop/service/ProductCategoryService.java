package webshop.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webshop.model.Product;
import webshop.model.ProductCategory;
import webshop.repository.ProductCategoryRepository;

@Service
public class ProductCategoryService {

  @Autowired
  private ProductCategoryRepository productCategoryRepository;

  public void createProduct(ProductCategory product) {
    productCategoryRepository.save(product);
  }

  public void deleteProductCategory(int id) {
    productCategoryRepository.deleteById(id);
  }

  public ProductCategory getProductCategoryById(Integer id) {
    return productCategoryRepository.getOne(id);
  }

  public List<ProductCategory> getAllProductCategories() {
    return productCategoryRepository.findAll();
  }


  public List<Product> getAllProductsOfCategory(String categoryName) {
    List<ProductCategory> categories = productCategoryRepository.findByName(categoryName);
    List<Product> products = new ArrayList<>();

    for (ProductCategory cat : categories) {
      products.addAll(cat.getProducts());
    }

    return products;
  }
}
