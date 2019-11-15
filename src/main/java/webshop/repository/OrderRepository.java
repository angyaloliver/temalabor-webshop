package webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webshop.model.OrderDetails;

public interface OrderRepository extends JpaRepository<OrderDetails, Integer> {

}
