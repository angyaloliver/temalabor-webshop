package webshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webshop.model.Product;
import webshop.model.ProductPrice;


import webshop.repository.ProductRepository;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  public void addProduct(String name, int number, String description, ProductPrice price) {
    Product p = Product.createNewProduct(name, number, description, price);
    productRepository.save(p);
  }

  public void deleteProduct(int id) {

  }

  public void changeNumberInStock(int id, int number) {

  }
}
