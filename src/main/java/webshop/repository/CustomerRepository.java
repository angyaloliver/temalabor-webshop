package webshop.repository;

import webshop.model.Customer;

public interface CustomerRepository {

  void save(Customer c);

  Customer findbyId(int id);

  void delete(Customer c);
}

