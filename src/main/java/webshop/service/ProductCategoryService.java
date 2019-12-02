package webshop.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
}
