package webshop.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import webshop.model.ProductCategory;

public interface ProductCategoryRepository extends
    JpaRepository<ProductCategoryRepository, Integer> {

  List<ProductCategory> findByName(String name);
}
