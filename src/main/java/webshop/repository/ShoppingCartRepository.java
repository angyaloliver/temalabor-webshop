package webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webshop.model.ShoppingCart;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

}
