package webshop;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import webshop.model.ProductCategory;
import webshop.repository.ProductCategoryRepository;

@SpringBootApplication
public class WebShopApplication implements CommandLineRunner {

  @Autowired
  ProductCategoryRepository productCategoryRepository;


  public static void main(String[] args) {
    SpringApplication.run(WebShopApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    productCategoryRepository.save(new ProductCategory("test category"));
  }

}
