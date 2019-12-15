package webshop.service;

import java.math.BigDecimal;
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

  public Integer createProduct(Product product) {
    return productRepository.save(product).getId();
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

  public void modifyProduct(Integer productToBeModifiedId, Product modifyingProduct) {
    Product productToBeModified = productRepository.getOne(productToBeModifiedId);
    productToBeModified.setName(modifyingProduct.getName());
    productToBeModified.setDescription(modifyingProduct.getDescription());
    productToBeModified.setOriginalPrice(modifyingProduct.getOriginalPrice());
    productToBeModified.setDiscountRate(modifyingProduct.getDiscountRate());
    productToBeModified.setImages(modifyingProduct.getImages());
    productToBeModified.setProductCategories(modifyingProduct.getProductCategories());
    productToBeModified.setNumberInStock(modifyingProduct.getNumberInStock());
  }

  public List<Product> getAllProducts(Integer pageNumber, Integer pageSize, String sortBy) {
    Pageable paging = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));

    Page<Product> pagedResult = productRepository.findAll(paging);

    if (pagedResult.hasContent()) {
      return pagedResult.getContent();
    } else {
      return new ArrayList<>();
    }
  }

  public int getMaxPrice() {
    List<Product> products = getAllProducts();

    BigDecimal max = BigDecimal.valueOf(0);
    for (Product product : products) {
      BigDecimal actPrice = product.getActualPrice();
      if (max.compareTo(actPrice) < 0) {
        max = actPrice;
      }
    }
    return max.intValue();
  }
}
