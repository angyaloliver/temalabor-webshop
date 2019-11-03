package webshop.service;

import webshop.model.Product;
import webshop.model.ProductPrice;


import webshop.repository.ProductRepository;

public class ProductService {

    ProductRepository productRepository;

    void addProduct(String name, int number, String description, ProductPrice price) {
        Product p = Product.createNewProduct(name, number, description, price);
        productRepository.save(p);
    }

    void deleteProduct(int id) {
        Product p = productRepository.findbyId(id);
        productRepository.delete(p);
    }

    void changeNumberInStock(int id, int number) { //Add new items (+) or buy some (-)
        Product p = productRepository.findbyId(id);
        p.setNumberInStock(p.getNumberInStock() + number);
        productRepository.save(p);
    }
}
