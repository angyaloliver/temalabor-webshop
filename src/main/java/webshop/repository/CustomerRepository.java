package webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webshop.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

  Customer findByContact_EmailAddress(String email);

  Customer findByContact_Username(String username);
}

