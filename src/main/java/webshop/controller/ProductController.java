package webshop.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import webshop.model.Product;
import webshop.service.ProductService;

@AllArgsConstructor
@RestController
@RequestMapping("products")
public class ProductController {

  ProductService productService;

  @PostMapping
  public void createProduct(
      @RequestBody Product product) {
    productService.createProduct(product);
  }

  @DeleteMapping("{id}")
  public void deleteProduct(
      @PathVariable("id") Integer id) {
    productService.deleteProduct(id);
  }

  @GetMapping("{id}")
  public Product getProductById(
      @PathVariable Integer id) {
    return productService.getProductById(id);
  }

  @GetMapping
  public List<Product> getPaginatedProducts(
      @RequestParam(defaultValue = "0") Integer pageNumber,
      @RequestParam(defaultValue = "10") Integer pageSize,
      @RequestParam(defaultValue = "id") String sortBy) {
    return productService.getAllProducts(pageNumber, pageSize, sortBy);
  }

  @GetMapping("/all")
  public List<Product> getAllProducts() {
    return productService.getAllProducts();
  }

  @PatchMapping("{id}")
  public void changeNumberInStock(
      @PathVariable("id") Integer id,
      @RequestParam("quantity") Integer quantity) {
    productService.changeNumberInStock(id, quantity);
  }

  @GetMapping("/max_price")
  public String getMaxPrice() {
    return Integer.toString(productService.getMaxPrice());
  }
}
