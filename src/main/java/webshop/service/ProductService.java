package webshop.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public List<Product> getAllProducts(Integer pageNumber, Integer pageSize, String sortBy) {
      Pageable paging = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));

      Page<Product> pagedResult = productRepository.findAll(paging);

      if(pagedResult.hasContent()) {
        return pagedResult.getContent();
      } else {
        return new ArrayList<Product>();
      }
    }
}
