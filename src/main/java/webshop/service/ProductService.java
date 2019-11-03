package webshop.service;

import webshop.model.Product;
import webshop.model.ProductPrice;


import webshop.repository.ProductRepository;

public class ProductService {

    ProductRepository productRepository;

    void addProduct(String name, int number, String description, ProductPrice price) {
        if (productRepository.existsbyName(name)) {
            Product p = Product.createNewProduct(name, number, description, price);

            productRepository.save(p);
        }
    }

    void deleteProduct(String name) {
        Product p = productRepository.findbyName(name);
        productRepository.delete(p);
    }

    void changeNumberInStock(int number, String name) { //Add new items (+) or buy some (-)
        Product p = productRepository.findbyName(name);
        p.setNumberInStock(p.getNumberInStock() + number);
        productRepository.save(p);
    }
}
