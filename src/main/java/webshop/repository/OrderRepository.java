package webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webshop.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
