package webshop.service;

import webshop.repository.CustomerRepository;
import webshop.repository.ProductRepository;
import webshop.repository.ShoppingCartRepository;

import webshop.model.Product;
import webshop.model.Customer;
import webshop.model.ShoppingCart;

public class ShoppingCartService {

    ProductRepository productRepository;
    ShoppingCartRepository shoppingCartRepository;
    CustomerRepository customerRepository;


    void addProductToCart(int id, int customerId) {
        Product p = productRepository.findbyId(id);
        Customer u = customerRepository.findbyId(customerId);
        ShoppingCart sc = u.getShoppingCart();

        sc.addProduct(p);

        shoppingCartRepository.save(sc);
        customerRepository.save(u);
    }

}
