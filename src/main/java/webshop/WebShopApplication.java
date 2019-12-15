package webshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import webshop.model.Role;
import webshop.repository.RoleRepository;

@SpringBootApplication
public class WebShopApplication implements CommandLineRunner {

  @Autowired
  RoleRepository roleRepository;

  public static void main(String[] args) {
    SpringApplication.run(WebShopApplication.class, args);
  }

  @Override
  public void run(String... args) {
    if (roleRepository.findByName("ROLE_USER") == null) {
      roleRepository.save(new Role("ROLE_USER"));
    }
    if (roleRepository.findByName("ROLE_ADMIN") == null) {
      roleRepository.save(new Role("ROLE_ADMIN"));
    }
  }

}
