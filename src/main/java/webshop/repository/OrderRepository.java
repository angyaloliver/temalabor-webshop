package webshop.repository;

import webshop.model.Order;

public interface OrderRepository {
    void save(Order o);

    Order findbyName(String name);
}
