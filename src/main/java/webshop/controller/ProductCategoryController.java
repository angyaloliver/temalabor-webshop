package webshop.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webshop.model.ProductCategory;
import webshop.service.ProductCategoryService;

@AllArgsConstructor
@RestController
@RequestMapping("categories")
public class ProductCategoryController {
  ProductCategoryService productCategoryService;

  @PostMapping
  public void createProduct(
      @RequestBody ProductCategory productCategory) {
    productCategoryService.createProduct(productCategory);
  }

  @DeleteMapping("{id}")
  public void deleteProduct(
      @PathVariable("id") Integer id) {
    productCategoryService.deleteProductCategory(id);
  }

  @GetMapping("{id}")
  public ProductCategory getProductCategoryById(
      @PathVariable Integer id) {
    return productCategoryService.getProductCategoryById(id);
  }

  @GetMapping
  public List<ProductCategory> getAllProductCategories() {
    return productCategoryService.getAllProductCategories();
  }

}
