package webshop.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import webshop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

  List<Product> findByName(String name);
}
