package webshop.repository;

import webshop.model.Product;

public interface ProductRepository {
    void save(Product p);

    Product findbyId(int id);

    boolean existsbyName(String name);

    void delete(Product p);
}
