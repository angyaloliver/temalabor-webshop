package webshop.repository;

import webshop.model.Customer;

public interface CustomerRepository {
    public void save(Customer c);
    public Customer findbyName(String name);
}

