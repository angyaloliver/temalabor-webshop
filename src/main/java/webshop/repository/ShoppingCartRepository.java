package webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webshop.model.ProductCategory;
import webshop.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

}
