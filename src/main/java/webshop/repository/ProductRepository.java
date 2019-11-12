package webshop.repository;

import webshop.model.Product;

public interface ProductRepository {

  void save(Product p);

  Product findbyId(int id);

  void delete(Product p);
}
