package webshop.repository;

import webshop.model.Order;

public interface OrderRepository {
    void save(Order o);

    Order findbyId(int id);
}
