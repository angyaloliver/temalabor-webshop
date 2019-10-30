package webshop.repository;

import webshop.model.Order;

public interface OrderRepository {
    public void save(Order o);
    public Order findbyName(String name);
}
