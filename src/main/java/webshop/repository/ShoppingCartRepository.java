package webshop.repository;

import webshop.model.ShoppingCart;

public interface ShoppingCartRepository {
    public void save(ShoppingCart sc);
    public ShoppingCart findbyId(String id);
}
