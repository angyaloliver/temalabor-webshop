package webshop.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webshop.model.Product;
import webshop.repository.ProductRepository;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  public void createProduct(Product product) {
    productRepository.save(product);
  }

  public void deleteProduct(int id) {
    productRepository.deleteById(id);
  }

  public Product getProductById(Integer id) {
    return productRepository.getOne(id);
  }

  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  public void changeNumberInStock(int productId, int number) {
    Product product = productRepository.getOne(productId);
    product.setNumberInStock(number);

    productRepository.save(product);
  }
}
